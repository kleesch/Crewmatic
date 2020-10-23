/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmatic;

import java.util.Random;

/**
 *
 * @author Kyle
 */
public class Tree {

    private Node[] map = new Node[0];
    private String id;

    public Tree(String name) {
        id = name;

    }

    public Node makeNode(String name, int x, int y) {
        Node[] temp_map = new Node[map.length + 1];
        System.arraycopy(map, 0, temp_map, 0, map.length);
        Node n = new Node(name, x, y);
        temp_map[temp_map.length - 1] = n;
        map = temp_map;
        return n;
    }

    public void connect(Node n1, Node n2) {
        n1.addConnection(n2);
        n2.addConnection(n1);
    }

    public Node getNodeById(String id) {
        for (Node map1 : map) {
            if (map1.getId().equals(id)) {
                return map1;
            }
        }
        return null;
    }
    
    public boolean isConnected(Node n1, Node n2){
        for(SimpleConnection c:n1.connections){
            if(c.n1.equals(n2)){
                return true;
            }
        }
        return false;
    }

    public PathConnection Path(String start_id, String end_id) {
        Node start = getNodeById(start_id);
        if(start_id.equals(end_id)){
            return(new PathConnection(start,0));
        }  
        for(Node n : map){
            n.visited=false;
        }
        start.visited=true;
        PriorityPathContainer queue = new PriorityPathContainer();
        for (SimpleConnection connection : start.connections) {
            queue.addPath((new PathConnection(connection.n1, connection.distance)));
            connection.n1.visited=true;
        }
        while (queue.hasNext()) {
            PathConnection next = queue.next();
            if (next.n1.getId().equals(end_id)) {
                return next;
            } else {
                for (SimpleConnection connection : next.n1.connections) {
                    if (!connection.n1.visited) {
                        PathConnection pc = new PathConnection(connection.n1, connection.distance);
                        pc.distance += next.distance;
                        pc.shortest_path = new Node[next.shortest_path.length + 1];
                        for (int i = 0; i < next.shortest_path.length; i++) {
                            pc.shortest_path[i] = next.shortest_path[i];
                        }
                        pc.shortest_path[pc.shortest_path.length - 1] = next.n1;
                        queue.addPath(pc);
                        connection.n1.visited=true;
                    } else {

                    }
                }
            }
        }
        System.out.println("Cannot path from "+start_id+" to "+end_id);
        return null;
    }
    
    public Node[] getMap(){
        return map;
    }
    
    public Node randomNode(){
        return map[new Random().nextInt(map.length)];
    }
}
