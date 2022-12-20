package edu.algos.li15_tree;

import edu.algos.li00_model.TreeNode;

public class RangeSumOfBst {

	public static void main(String[] args) {
		RangeSumOfBst obj = new RangeSumOfBst();
		
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = bst.insert(null, 10);
		bst.insert(root, 2);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 5);
		bst.insert(root, 15);
		bst.insert(root, 3);
		
		System.out.println(obj.rangeSumBST(root, 2, 5));
	}

	/*
	 * Problem: https://leetcode.com/problems/range-sum-of-bst/ 
	 * */
	public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        
        if(root.val > high)
            return rangeSumBST(root.left, low, high);
        else if(root.val < low)
            return rangeSumBST(root.right, low, high);
        else
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
