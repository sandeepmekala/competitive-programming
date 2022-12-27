package edu.algos.li15_tree.easy;

import edu.algos.li00_model.TreeNode;

public class L101_SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Problem: https://leetcode.com/problems/symmetric-tree/
	 * Idea: We have to use two params denoting left and rught sub trees which symmetric clones.
	 * Recursively, pass corresponding symmetric roots.
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
