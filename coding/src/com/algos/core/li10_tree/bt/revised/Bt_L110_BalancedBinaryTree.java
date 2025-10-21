package  com.algos.core.li10_tree.bt.revised;

import com.algos.core.models.TreeNode;

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
	// Time: O(n)
    // space: O(1)
	public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

	private int depth(TreeNode root) {
		if(root == null)
			return 0;

		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);

		if(leftDepth == -1 || rightDepth  == -1) return -1;
		if(Math.abs(leftDepth - rightDepth) > 1) return -1;

		return 1 + Math.max(leftDepth, rightDepth);
	}

}
