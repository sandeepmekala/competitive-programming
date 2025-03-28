package  com.algos.core.li10_tree.bt.revised;

import  com.algos.core.li30_model.TreeNode;

public class Bt_L101_SymmetricTree {

	public static void main(String[] args) {
		Bt_L101_SymmetricTree obj = new Bt_L101_SymmetricTree();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

		System.out.println(obj.isSymmetric(root));
	}

	
	// Problem: https://leetcode.com/problems/symmetric-tree/
	// Idea: We have to use two params denoting left and right sub trees which symmetric clones.
	// Recursively, pass corresponding symmetric roots.
	// Time: O(n)
    // space: O(1)
	public boolean isSymmetric(TreeNode root) {
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null || right == null) 
			return left == right;

		return (left.val == right.val) && 
				isSymmetric(left.left, right.right) && 
				isSymmetric(left.right, right.left);
	}

}
