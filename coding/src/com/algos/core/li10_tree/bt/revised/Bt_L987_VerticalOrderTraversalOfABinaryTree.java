package  com.algos.core.li10_tree.bt.revised;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import  com.algos.core.li30_model.TreeNode;

public class Bt_L987_VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        Bt_L987_VerticalOrderTraversalOfABinaryTree obj = new Bt_L987_VerticalOrderTraversalOfABinaryTree();

        TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
        root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(obj.verticalTraversal(root));
    }

    // Problem: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    // Idea: Map each node to 2d plane row, col coordinates. Store row, cols in queue while doing bfs.
    // Group all the cols and respect rows in TreeMaps.
    // Time: O(n)
    // space: O(n)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple curr = q.remove();
            TreeNode node = curr.node;
            int row = curr.row, col = curr.col;
            
            if(!map.containsKey(col)) 
                map.put(col, new TreeMap<>());
            if(!map.get(col).containsKey(row)) 
                map.get(col).put(row, new PriorityQueue<Integer>());
            map.get(col).get(row).add(node.val);

            if(node.left != null) 
                q.add(new Tuple(node.left, row+1, col-1));
            if(node.right != null) 
                q.add(new Tuple(node.right, row+1, col+1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> cols: map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: cols.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.remove());
                }
            }
        }

        return ans;
    }
}

class Tuple{
    public TreeNode node;
    public int row;
    public int col;
    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
    
}