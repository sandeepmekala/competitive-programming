package  com.algos.core.li10_tree.bt.revised;

import  com.algos.core.li30_model.TreeNode;

public class Bt_L104_MaximumDepthOfBinaryTree {

	public static void main(String[] args) {
		Bt_L104_MaximumDepthOfBinaryTree obj = new Bt_L104_MaximumDepthOfBinaryTree();
				
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.maxDepth(root));
		
	}

	// Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
	// Idea: Maximum depth is the number of nodes along the longest path to any leaf node.
	// 1 + max(left, right) 
	// Time: O(n)
    // space: O(1)
	public int maxDepth(TreeNode root) {
        if(root == null) 
			return 0;
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return 1 + Math.max(leftDepth, rightDepth);
    }
}
