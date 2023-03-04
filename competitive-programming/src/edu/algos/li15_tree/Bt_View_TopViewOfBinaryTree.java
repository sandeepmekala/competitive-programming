package edu.algos.li15_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import edu.algos.li00_model.TreeNode;

public class Bt_View_TopViewOfBinaryTree {
    public static void main(String[] args) {
        Bt_View_TopViewOfBinaryTree obj = new Bt_View_TopViewOfBinaryTree();
        
        TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
        root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(obj.topView(root));
    }

    // Problem: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    // Idea: Use column number logic. Do col-1 when you are left and col+1 when going right.
    public List<Integer> topView(TreeNode root){
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair pair = q.remove();
            TreeNode node = pair.node;
            int col = pair.col;

            if(!map.containsKey(col)) map.put(col, node.val);

            if(node.left !=  null) q.add(new Pair(node.left, col-1));
            if(node.right !=  null) q.add(new Pair(node.right, col+1));
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer val: map.values()){
            ans.add(val);
        }
        return ans;
    }
}
class Pair{
    TreeNode node;
    int col;
    public Pair(TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}
