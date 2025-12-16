package li13_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs_L133_CloneGraph {

    public static void main(String[] args) {
        Bfs_L133_CloneGraph obj = new Bfs_L133_CloneGraph();

        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        n1.neighbors.add(n2);
        n2.neighbors.add(n3);
        n3.neighbors.add(n1);

        GraphNode copy = obj.cloneGraph(n1);
        System.out.println(copy);
    }

    // Problem: https://leetcode.com/problems/clone-graph/
    // Idea: BFS the graph and create copy for each node and store in map
    // For each node in map, get its clone and create links.
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null)
            return null;

        HashMap<GraphNode, GraphNode> map = new HashMap<>();
        GraphNode newRoot = new GraphNode(node.val);
        map.put(node, newRoot);

        Queue<GraphNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) { // bfs
            GraphNode curr = q.remove();
            for (GraphNode nei : curr.neighbors) {
                if (!map.containsKey(nei)) { // map acts as visited
                    GraphNode newNode = new GraphNode(nei.val);
                    map.put(nei, newNode);
                    q.add(nei);
                }
            }
        }

        for (GraphNode curr : map.keySet()) {
            for (GraphNode nei : curr.neighbors) {
                map.get(curr).neighbors.add(map.get(nei));
            }
        }

        return map.get(node);
    }

}

class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public GraphNode(int _val, List<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
