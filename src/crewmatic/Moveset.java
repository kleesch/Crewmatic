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

import crewmatic.Crewmatic.Movement;

public class Moveset {

    public int distance;
    public Movement dir;
    
    Moveset(Movement di,int d){
        distance=d;
        dir=di;
    }
}
