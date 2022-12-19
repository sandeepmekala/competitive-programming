package edu.algos.li14_tree;

import java.util.ArrayList;
import java.util.List;

import edu.algos.li00_model.TreeNode;

public class BinaryTreePaths {

	public static void main(String[] args) {
		BinaryTreePaths obj = new BinaryTreePaths();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.binaryTreePaths(root));
	}
	/*
	 * Problem: https://leetcode.com/problems/binary-tree-paths/
	 * 
	 * */
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        String path = "";
        binaryTreePaths(root, path, result);
        return result;
    }
    
    private void binaryTreePaths(TreeNode root, String path, List<String> result) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            path += root.val;
            result.add(path);
        }else{
            path += root.val+"->";
            if(root.left != null) binaryTreePaths(root.left, path, result);
            if(root.right != null) binaryTreePaths(root.right, path, result);
        }
             
    }

}
