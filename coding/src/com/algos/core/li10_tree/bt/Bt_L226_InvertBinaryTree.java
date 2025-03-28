package  com.algos.core.li10_tree.bt;

import  com.algos.core.li30_model.TreeNode;

public class Bt_L226_InvertBinaryTree {

	public static void main(String[] args) {
		Bt_L226_InvertBinaryTree obj = new Bt_L226_InvertBinaryTree();
				
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		obj.invertTree(root);
	}
	
	// Problem: https://leetcode.com/problems/invert-binary-tree/
	// Idea: Recursively invert left and right sub treens and assign left to right and right to left ptr's.
	// Time: O(n)
    // space: O(1)
	public TreeNode invertTree(TreeNode root) {
		if(root ==  null) 
			return root;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
        return root;
    }

}
