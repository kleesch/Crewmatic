/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmatic;

import com.sun.glass.events.KeyEvent;
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
public class Wires extends Task {
    @Override
    public void execute() throws AWTException,InterruptedException{
        r = new Robot();
        goTo(1792,937);
        r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(20);
        r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(500);
        Color top_left = r.getPixelColor(515, 270);
        Color upper_middle_left = r.getPixelColor(515, 460);
        Color lower_middle_left = r.getPixelColor(515, 650);
        Color bottom_left = r.getPixelColor(515, 830);

        Color top_right = r.getPixelColor(1405, 270);
        Color upper_middle_right = r.getPixelColor(1405, 460);
        Color lower_middle_right = r.getPixelColor(1405, 650);
        Color bottom_right = r.getPixelColor(1405, 830);

        String[] left = new String[4];
        left[0] = identifyColor(top_left);
        left[1] = identifyColor(upper_middle_left);
        left[2] = identifyColor(lower_middle_left);
        left[3] = identifyColor(bottom_left);

        String[] right = new String[4];
        right[0] = identifyColor(top_right);
        right[1] = identifyColor(upper_middle_right);
        right[2] = identifyColor(lower_middle_right);
        right[3] = identifyColor(bottom_right);

        int match1 = 0;
        for (int i = 0; i < 4; i++) {
            if (left[0].equals(right[i])) {
                match1 = i;
            }
        }
        goTo(590, 275);
        Thread.sleep(40);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);
        goTo(1300, 270 + 190 * match1);
        Thread.sleep(40);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        int match2 = 0;
        for (int i = 0; i < 4; i++) {
            if (left[1].equals(right[i])) {
                match2 = i;
            }
        }
        goTo(590, 460);
        Thread.sleep(40);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);
        goTo(1300, 270 + 190 * match2);
        Thread.sleep(40);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        int match3 = 0;
        for (int i = 0; i < 4; i++) {
            if (left[2].equals(right[i])) {
                match3 = i;
            }
        }
        goTo(590, 650);
        Thread.sleep(40);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);
        goTo(1300, 270 + 190 * match3);
        Thread.sleep(40);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        int match4 = 0;
        for (int i = 0; i < 4; i++) {
            if (left[3].equals(right[i])) {
                match4 = i;
            }
        }
        goTo(590, 840);
        Thread.sleep(40);
        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(40);
        goTo(1300, 270 + 190 * match4);
        Thread.sleep(40);
        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        while(true){
            Thread.sleep(100);
            if (isCompleted()){
                break;
            }
        }
    }
    
     private String identifyColor(Color c) {
        if (c.getGreen() > 50) {
            //System.out.println("Yellow");
            return "Yellow";
        } else if (c.getBlue() == 255 && c.getRed() == 255) {
            //System.out.println("Pink");
            return "Pink";
        } else if (c.getBlue() == 255) {
            //System.out.println("Blue");
            return "Blue";
        } else {
            //System.out.println("Red");
            return "Red";
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
     public boolean isCompleted(){
         return (!r.getPixelColor(474,125).equals(new Color(238,238,238)));
     }
}
