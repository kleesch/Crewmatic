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
public class NodeArray {
    public Node[] main=new Node[50];
    private int num=0;
    
    NodeArray(){
        
    }
    public int getLength(){
        return num;
    }
    
    public void push(Node n){
        boolean is_in=false;
        for(int i=0;i<num;i++){
            if(main[i].equals(n)){
                is_in=true;
            }
        }
        if(!is_in){
            main[num++]=n;
        }
    }
    
    public void pop(int pos){
        //System.out.println("Removing "+main[pos].getId());
        for(int i=pos;i<num;i++){
            //System.out.println(main[pos].getId()+" > "+main[pos+1].getId());
            main[i]=main[i+1];
        }
        num--;
    }
    
}
