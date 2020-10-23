/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmatic;

import java.awt.Color;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import crewmatic.Crewmatic.Movement;

/**
 *
 * @author Kyle
 */
public class Player {

    private Node location;
    private Robot r;
    private double speed; //In pixels per second
    private Color color;

    private int search_radius = 25; //Pixels on either side to check if the player is where they should be.

    public Player(Robot r1, Node loc, double s_speed, Color c) {
        r = r1;
        location = loc;
        speed = s_speed;
        color = c;
    }

    public void move(Moveset set) throws InterruptedException {
        switch (set.dir) {
            case UP:
                r.keyPress(KeyEvent.VK_W);
                Thread.sleep((int) (1000 * (set.distance / (speed * 103.9))));
                r.keyRelease(KeyEvent.VK_W);
                break;
            case DOWN:
                r.keyPress(KeyEvent.VK_S);
                Thread.sleep((int) (1000 * (set.distance / (speed * 103.9))));
                r.keyRelease(KeyEvent.VK_S);
                break;
            case LEFT:
                r.keyPress(KeyEvent.VK_A);
                Thread.sleep((int) (1000 * (set.distance / (speed * 103.9))));
                r.keyRelease(KeyEvent.VK_A);
                break;
            case RIGHT:
                r.keyPress(KeyEvent.VK_D);
                Thread.sleep((int) (1000 * (set.distance / (speed * 103.9))));
                r.keyRelease(KeyEvent.VK_D);
                break;
        }
    }

    public Moveset makeInstruction(Node n) throws InterruptedException {
        int x_diff = location.getX() - n.getX();
        int y_diff = location.getY() - n.getY();
        if (x_diff == 0) { //MOVE UP DOWN
            if (y_diff > 0) {
                return (new Moveset(Movement.UP, y_diff));
            } else {
                return (new Moveset(Movement.DOWN, Math.abs(y_diff)));
            }
        } else if (y_diff == 0) { //MOVE RIGHT LEFT
            if (x_diff > 0) {
                return (new Moveset(Movement.LEFT, x_diff));
            } else {
                return (new Moveset(Movement.RIGHT, Math.abs(x_diff)));
            }
        } else {
            System.out.println("Cannot make path to " + n.getId() + " from " + location.getId());
            return (new Moveset(Movement.DOWN, 0));
        }
    }

    public void followPath(PathConnection path) throws InterruptedException {
        for (Node n : path.shortest_path) {
            //System.out.println("Moving to " + n.getId());
            move(makeInstruction(n));
            location = n;
            if (location.getId().equals("n_102")) {
                correctLocation();
            }
            Thread.sleep(30);
        }
        move(makeInstruction(path.n1));
        location = path.n1;

        if (location.getId().equals("n_102")) {
            correctLocation();
        }
        System.out.println("Movement complete");
    }

    public Node getLocation() {
        return location;
    }

    public void correctLocation() throws InterruptedException {
        move(new Moveset(Movement.DOWN, 30));
        move(new Moveset(Movement.RIGHT, 30));
        move(new Moveset(Movement.LEFT, 13));
        move(new Moveset(Movement.UP, 5));
    }

    public NodeArray findTasks(Tree t) throws InterruptedException {
        Node[] points = t.getMap();
        NodeArray tasks = new NodeArray();
        setMapState(true);
        for (int i = 0; i < points.length; i++) {
            Color c = r.getPixelColor(points[i].getTaskX(), points[i].getTaskY());
            if (2 * c.getBlue() < (c.getRed() + c.getGreen()) && points[i].associated_task != null) {
                //System.out.println("Task at "+points[i].getId());
                boolean valid = true;
                for (int n = 0; n < tasks.getLength(); n++) {
                    if (tasks.main[n].connectsWith(points[i])) { //If the two nodes with takss connect
                        if (points[i].connections.length == 1) { //And the new node has only 1 connection (the other node)
                            tasks.main[n] = points[i]; //The new node must be an endpoint, which connects to a task. Takes priority.
                            valid = false; //Since we replaced, don't need to add it
                        } else {
                            valid = false; //Same priority, don't need it.
                        }
                    }
                }
                if (valid) {
                    tasks.push(points[i]);
                }
            }
        }
        for (int i = 0; i < tasks.getLength(); i++) {
            System.out.println("Task at " + tasks.main[i].getId());
        }
        setMapState(false);
        return tasks;

    }

    private void setMapState(boolean state) throws InterruptedException {
        //System.out.println("Setting to "+state);
        Color c = r.getPixelColor(1790, 569);
        Color c2 = r.getPixelColor(300, 175);
        if (c.getBlue() > 200 && c2.getBlue() > 200 && !state) {
            r.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
        } else if (!(c.getBlue() > 200) && !(c2.getBlue() > 200) && state) {
            r.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(50);
            r.keyRelease(KeyEvent.VK_TAB);
        }
        Thread.sleep(50);
    }
}
