/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmatic;

import java.awt.AWTException;
import java.awt.Robot;

/**
 *
 * @author Kyle
 */
public abstract class Task {
    Robot r;
   
    public abstract void execute() throws AWTException,InterruptedException;
    
    public abstract boolean isCompleted();
}
