/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmatic;

/**
 *
 * @author Kyle
 */
public class PriorityPathContainer {

    PathConnection[] queue = {};

    public void addPath(PathConnection pc) {
        PathConnection[] temp = new PathConnection[queue.length + 1];
        if (temp.length == 1) {
            temp[0] = pc;
        } else {
            int i;
            for (i=0; i < temp.length-1; i++) {
                if (queue[i].distance < pc.distance) {
                    temp[i] = queue[i];
                } else {
                    break;
                }
            }
            temp[i]=pc;
            for (i=i+1;i<temp.length;i++){
                temp[i]=queue[i-1];
            }
        }
        queue = temp;
    }

    public PathConnection next() {
        PathConnection returning = queue[0];
        PathConnection[] temp = new PathConnection[queue.length - 1];
        if (temp.length > 0) {
            for (int i = 1; i <= temp.length; i++) {
                temp[i - 1] = queue[i];
            }
        }
        queue = temp;
        return returning;
    }

    public boolean hasNext() {
        return queue.length > 0;
    }

    public boolean isIn(Node n) {
        for (PathConnection temp : queue) {
            if (temp.n1.equals(n)) {
                return true;
            }
        }
        return false;
    }
}
