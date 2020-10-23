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
public class DownloadUpload extends Task {

    @Override
    public void execute() throws InterruptedException, AWTException {
        r = new Robot();
        goTo(1792, 937);
        r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);
        r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(500);
        goTo(959, 646);
        Thread.sleep(10);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(10);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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
        return (!r.getPixelColor(314,215).equals(new Color(238, 238, 238)));
    }
}
