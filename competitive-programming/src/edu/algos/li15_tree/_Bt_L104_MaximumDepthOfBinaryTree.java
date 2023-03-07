package edu.algos.li15_tree;

import edu.algos.li00_model.TreeNode;

public class _Bt_L104_MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		_Bt_L104_MaximumDepthOfBinaryTree obj = new _Bt_L104_MaximumDepthOfBinaryTree();
				
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.maxDepth(root));
		
	}

	// Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
	// Idea: 1+max(left, right) 
	public int maxDepth(TreeNode root) {
        if(root == null) {
			return 0;
		}
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return 1 + Math.max(leftDepth, rightDepth);
    }
}
