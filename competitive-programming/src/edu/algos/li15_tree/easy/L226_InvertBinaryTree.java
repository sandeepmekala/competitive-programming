package edu.algos.li15_tree.easy;

import edu.algos.li00_model.TreeNode;

public class L226_InvertBinaryTree {

	public static void main(String[] args) {
		L226_InvertBinaryTree obj = new L226_InvertBinaryTree();
				
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		bt.inorder(root);
		obj.invertTree(root);
		System.out.println();
		bt.inorder(root);
	}
	
	// Problem: https://leetcode.com/problems/invert-binary-tree/
	// Idea: Recursively invert left and right sub treens and assign left to right and right left ptr's.
	public TreeNode invertTree(TreeNode root) {
		if(root ==  null) return root;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
        return root;
    }

}
