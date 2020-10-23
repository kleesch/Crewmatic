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
public class Node {
    private String id="Not Set";
    
    private int x;
    private int y;
    
    private int pos_exception_x;
    private int pos_exception_y;
    
    public boolean visited=false;
    
    public Task associated_task=null;
    
    public SimpleConnection[] connections=new SimpleConnection[0];
    
    public Node(String name, int _x, int _y){
        id=name;
        x=_x;
        y=_y;  
        pos_exception_x=x;
        pos_exception_y=y;
    }
    
    public void addConnection(Node n){
        SimpleConnection[] temp_map=new SimpleConnection[connections.length+1];
        for(int i=0;i<connections.length;i++)
            temp_map[i]=connections[i];
        temp_map[temp_map.length-1]=new SimpleConnection(this,n);
        connections=temp_map;
    }
    
    public String getId(){
        return id;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getTaskX(){
        return pos_exception_x;
    }
    
    public int getTaskY(){
        return pos_exception_y;
    }
    
    public void setPositionException(int nx, int ny){
        pos_exception_x=nx;
        pos_exception_y=ny;
    }
    
    
    private boolean isIn(Node[] arr, Node n){
        for(int i=0;i<arr.length;i++){
            if (arr[i].equals(n)){
                return true;
            }
        }
        return false;
    }
    
    public boolean connectsWith(Node n){
        for(int i=0;i<connections.length;i++){
            if(connections[i].n1.equals(n)){
                return true;
            }
        }
        return false;
    }
    
    public void listConnections(){
        for(SimpleConnection c:connections){
            System.out.println(c.n1.getId());
        }
    }
}
