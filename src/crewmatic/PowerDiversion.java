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
public class PowerDiversion extends Task {

    @Override
    public void execute() throws InterruptedException, AWTException {
        r = new Robot();
        goTo(1792, 937);
        r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);
        r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(500);

        boolean complete = false;
        for (int i = 0; i < 8 && !complete; i++) {
            if (!r.getPixelColor(591 + 96 * i, 754).equals(new Color(68, 0, 0))) {
                goTo(591 + 96 * i, 754);
                r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(100);
                goTo(591 + 95 * i, 634);
                Thread.sleep(100);
                r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                complete = true;
                Thread.sleep(1000);
            }
        }

        while (true) {
            Thread.sleep(100);
            if (isCompleted()) {
                break;
            }
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
        return (!r.getPixelColor(455, 115).equals(new Color(238, 238, 238)));
    }
}
