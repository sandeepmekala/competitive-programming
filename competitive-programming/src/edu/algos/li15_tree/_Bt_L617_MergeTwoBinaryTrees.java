package edu.algos.li15_tree;

import edu.algos.li30_model.TreeNode;

public class _Bt_L617_MergeTwoBinaryTrees {

	public static void main(String[] args) {
		_Bt_L617_MergeTwoBinaryTrees obj = new _Bt_L617_MergeTwoBinaryTrees();
		
		_Bst_L701_InsertIntoABinarySearchTree bst1 = new _Bst_L701_InsertIntoABinarySearchTree();
		TreeNode root1 = bst1.insertIntoBST(null, 10);
		bst1.insertIntoBST(root1, 2);
		bst1.insertIntoBST(root1, 4);
		bst1.insertIntoBST(root1, 6);
		bst1.insertIntoBST(root1, 5);
		bst1.insertIntoBST(root1, 15);
		bst1.insertIntoBST(root1, 3);
		
		_Bst_L701_InsertIntoABinarySearchTree bst2 = new _Bst_L701_InsertIntoABinarySearchTree();
		TreeNode root2 = bst2.insertIntoBST(null, 10);
		bst2.insertIntoBST(root2, 2);
		bst2.insertIntoBST(root2, 4);
		bst2.insertIntoBST(root2, 6);
		bst2.insertIntoBST(root2, 5);
		bst2.insertIntoBST(root2, 15);
		bst2.insertIntoBST(root2, 3);
		
		obj.mergeTrees(root1, root2);
		//bst1.inorder(root1);
	}

	/*
	 * Problem: https://leetcode.com/problems/merge-two-binary-trees/
	 * Idea: Traverse both the lists at the same time.
	 * */
	// time: O(n)
    // space: O(1)
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) 
			return null;
        else if(root1 == null) 
			return root2;
        else if(root2 == null) 
			return root1;
        else{
            root1.val = root1.val+root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
