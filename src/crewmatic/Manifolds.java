/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmatic;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author Kyle
 */
public class Manifolds extends Task {

    @Override
    public void execute() throws InterruptedException, AWTException {
        r = new Robot();
        goTo(1792, 937);
        r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);
        r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(500);
        int[][] boxes = {
            {587, 395},
            {738, 395},
            {892, 395},
            {1045, 395},
            {1198, 395},
            {587, 550},
            {738, 550},
            {892, 550},
            {1045, 550},
            {1198, 550},};
        int[][] click_order = new int[10][2];

        for (int i = 0; i < boxes.length; i++) {
            click_order[getNumber(boxes[i][0], boxes[i][1]) - 1] = boxes[i];
        }

        for (int i = 0; i < click_order.length; i++) {
            goTo(click_order[i][0] + 68, click_order[i][1] + 68);
            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(20);
            r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(20);
        }
        Thread.sleep(3000);
        while (true) {
            Thread.sleep(100);
            if (isCompleted()) {
                break;
            }
        }
    }
    
    public static int getNumber(int x, int y) throws AWTException { //Give corner pixel 587,395
        Robot r = new Robot();
        if (r.getPixelColor(x + 66, y + 80).getBlue() < 150) {
            if (r.getPixelColor(x + 52, y + 44).getBlue() < 150) {
                return 2;
            } else if (r.getPixelColor(x + 48, y + 36).getBlue() < 150) {
                return 7;
            } else {
                return 1;
            }
        } else if (r.getPixelColor(x + 48, y + 83).getBlue() < 150) {
            if (r.getPixelColor(x + 79, y + 48).getBlue() < 150) {
                return 8;
            } else if (r.getPixelColor(x + 48, y + 68).getBlue() < 150) {
                return 6;
            } else {
                return 5;
            }
        } else if (r.getPixelColor(x + 84, y + 67).getBlue() < 150) {
            if (r.getPixelColor(x + 49, y + 69).getBlue() < 150) {
                return 4;
            } else if (r.getPixelColor(x + 49, y + 92).getBlue() < 150) {
                return 3;
            } else {
                return 9;
            }
        } else {
            return 10;
        }

    }

    private void goTo(int x, int y) throws AWTException, InterruptedException {
        for (int count = 0; (MouseInfo.getPointerInfo().getLocation().getX() != x
                || MouseInfo.getPointerInfo().getLocation().getY() != y)
                && count < 100; count++) {
            new Robot().mouseMove(x, y);
        }
    }

    @Override
    public boolean isCompleted() {
        return (!r.getPixelColor(460, 345).equals(new Color(238, 238, 238)));
    }
}
