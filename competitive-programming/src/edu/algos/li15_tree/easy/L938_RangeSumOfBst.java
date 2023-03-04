package edu.algos.li15_tree.easy;

import edu.algos.li00_model.TreeNode;
import edu.algos.li15_tree.medium._Bst_L701_InsertIntoABinarySearchTree;

public class L938_RangeSumOfBst {

	public static void main(String[] args) {
		L938_RangeSumOfBst obj = new L938_RangeSumOfBst();
		
		_Bst_L701_InsertIntoABinarySearchTree bst = new _Bst_L701_InsertIntoABinarySearchTree();
		TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);
		
		System.out.println(obj.rangeSumBST(root, 2, 5));
	}

	/*
	 * Problem: https://leetcode.com/problems/range-sum-of-bst/ 
	 * Idea: If root value is greater then the high search in left subtree
	 * If root value is less then low search in right subtree.
	 * else root val should in sum. Add it and recursively search left and right subtrees.
	 * 
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
