package edu.algos.li15_tree.easy;

import edu.algos.li00_model.TreeNode;

public class L110_BalancedBinaryTree {

	public static void main(String[] args) {
		L110_BalancedBinaryTree obj = new L110_BalancedBinaryTree();
		
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
	public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diff = Math.abs(leftHeight - rightHeight);
        
        return (diff <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

}
