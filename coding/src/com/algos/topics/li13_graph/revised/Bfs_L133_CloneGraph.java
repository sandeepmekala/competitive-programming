package com.algos.topics.li13_graph.revised;

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
        if (node == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node newRoot = new Node(node.val);
        map.put(node, newRoot);

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) { // bfs
            Node curr = q.remove();
            for (Node nei : curr.neighbors) {
                if (!map.containsKey(nei)) { // map acts as visited
                    Node newNode = new Node(nei.val);
                    map.put(nei, newNode);
                    q.add(nei);
                }
            }
        }

        for (Node curr : map.keySet()) {
            for (Node nei : curr.neighbors) {
                map.get(curr).neighbors.add(map.get(nei));
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
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
