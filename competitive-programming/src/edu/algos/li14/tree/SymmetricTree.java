package edu.algos.li14.tree;

import edu.algos.li00_model.TreeNode;

public class SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Problem: https://leetcode.com/problems/symmetric-tree/
	 * 
	 * */
	public boolean isSymmetric(TreeNode root) {

		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left == null || right == null) {
			return false;
		}

		return (left.val == right.val) && 
				isSymmetric(left.left, right.right) && 
				isSymmetric(left.right, right.left);
	}

}
