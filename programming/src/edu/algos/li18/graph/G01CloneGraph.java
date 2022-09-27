package edu.algos.li18.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class G01CloneGraph {

	public static void main(String[] args) {
		G01CloneGraph obj = new G01CloneGraph();
		
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n3);
		n3.neighbors.add(n1);
		
		Node copy = obj.cloneGraph(n1);
		System.out.println(copy);
	}
	
	public Node cloneGraph(Node node) {
        if(node  == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node current = queue.remove();
            if(!map.containsKey(current)){
                Node newNode = new Node(current.val);
                map.put(current, newNode);
                for(Node neighbor: current.neighbors){
                    queue.add(neighbor);
                }
            }
        }
        for(Node current: map.keySet()){
            for(Node neighbor: current.neighbors){
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }

}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
