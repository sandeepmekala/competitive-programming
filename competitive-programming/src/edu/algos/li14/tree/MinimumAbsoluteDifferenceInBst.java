package edu.algos.li14.tree;

import edu.algos.li00.model.TreeNode;

public class MinimumAbsoluteDifferenceInBst {

	public static void main(String[] args) {
		MinimumAbsoluteDifferenceInBst obj = new MinimumAbsoluteDifferenceInBst();
		
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = bst.insert(null, 10);
		bst.insert(root, 2);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 5);
		bst.insert(root, 15);
		bst.insert(root, 3);
		
		System.out.println(obj.getMinimumDifference(root));
	}

	/*
	 * Problem: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
	 * 	 
	 * */
	int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        
        int left = getMinimumDifference(root.left);
        int diff = Math.abs(prev - root.val);
        prev = root.val;
        int right = getMinimumDifference(root.right);
                                                
        return Math.min(diff, Math.min(left, right));
                                              
    }
}
