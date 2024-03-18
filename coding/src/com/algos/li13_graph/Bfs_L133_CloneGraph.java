package  com.algos.li13_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs_L133_CloneGraph {

	public static void main(String[] args) {
		Bfs_L133_CloneGraph obj = new Bfs_L133_CloneGraph();
		
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n3);
		n3.neighbors.add(n1);
		
		Node copy = obj.cloneGraph(n1);
		System.out.println(copy);
	}
	
    // Problem: https://leetcode.com/problems/clone-graph/
    // Idea: BFS the graph and create copy for each node and store in map
    // For each node in map, get its clone and create links.
	public Node cloneGraph(Node node) {
        if(node  == null)
            return null;
        
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        Node newRoot = new Node(node.val);
        map.put(node, newRoot);
        while(!queue.isEmpty()){    // bfs
            Node current = queue.remove();
            if(!map.containsKey(current)){      // acts as visited
                Node newNode = new Node(current.val);
                map.put(current, newNode);
                for(Node neigh: current.neighbors){
                    queue.add(neigh);
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
