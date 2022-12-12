package edu.algos.li14.tree;

import edu.algos.li00_model.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		PathSum obj = new PathSum();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.hasPathSum(root, 6));
		
	}
	
	/*
	 * Problem: https://leetcode.com/problems/path-sum/
	 * 
	 * */
	public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null ) return false;
        
        targetSum = targetSum-root.val;
        if(root.left == null && root.right == null && targetSum == 0) return true;
        
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

}
