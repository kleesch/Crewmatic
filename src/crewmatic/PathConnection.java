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
public class PathConnection {
    public Node n1;
    public int distance=0;
    public Node[] shortest_path=new Node[0];
    
    public PathConnection(Node one){
        n1=one;
    }
    
    public PathConnection(Node one, int dist){
        n1=one;
        distance=dist;
    }
}
