package  com.algos.li15_tree;

import  com.algos.li30_model.TreeNode;

public class Bt_L110_BalancedBinaryTree {

	public static void main(String[] args) {
		Bt_L110_BalancedBinaryTree obj = new Bt_L110_BalancedBinaryTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.isBalanced(root));
	}
	
	// Problem: https://leetcode.com/problems/balanced-binary-tree/
	// Idea: Check is height is balanced for the root node and check if left and right sub trees are balanced recursively.
	// time: O(n)
    // space: O(1)
	public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

	private int height(TreeNode root) {
		if(root == null) 
			return 0;
		
		int leftHt = height(root.left);
		int rightHt = height(root.right);
		
		if(leftHt == -1 || rightHt  == -1) return -1;
		int diff = Math.abs(leftHt - rightHt);
		if(diff > 1) return -1;

		return 1 + Math.max(leftHt, rightHt);
	}

}
