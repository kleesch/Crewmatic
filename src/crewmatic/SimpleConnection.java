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
public class SimpleConnection {
    public Node n1;
    public int distance;

    public SimpleConnection(Node orig, Node one){
        n1=one;
        int x1=n1.getX();
        int y1=n1.getY();
        int x2=orig.getX();
        int y2=orig.getY();
        if(x1==x2){
            distance=Math.abs(y1-y2);
        } else if(y1==y2){
            distance=Math.abs(x1-x2);
        } else {
            System.out.println("Error in simple connecting "+n1.getId()+" and "+orig.getId());
        }
    }
}
