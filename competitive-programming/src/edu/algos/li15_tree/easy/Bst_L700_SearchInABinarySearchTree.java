package edu.algos.li15_tree.easy;

import edu.algos.li00_model.TreeNode;
import edu.algos.li15_tree.medium._Bst_L701_InsertIntoABinarySearchTree;

public class Bst_L700_SearchInABinarySearchTree {
    public static void main(String[] args) {
        Bst_L700_SearchInABinarySearchTree obj = new Bst_L700_SearchInABinarySearchTree();
        
        _Bst_L701_InsertIntoABinarySearchTree bst = new _Bst_L701_InsertIntoABinarySearchTree();
        TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);

        System.out.println(obj.searchBST(root, 4));   
		System.out.println(obj.searchBstIterative(root, 4));   
    }

    // Problem: https://leetcode.com/problems/search-in-a-binary-search-tree/ 
    // Idea: If val < root, search in left subtree else search in right subtree.
    public TreeNode searchBST(TreeNode  root, int val){
		if(root == null || root.val == val)
			return root;
		
		if(val < root.val){
			return searchBST(root.left, val);
		}else{
			return searchBST(root.right, val);
		}
	}

	public TreeNode searchBstIterative(TreeNode  root, int val){
		TreeNode curr = root;
		while(curr != null && curr.val != val){
			curr = val<curr.val? curr.left: curr.right;
		}

		return curr;
	}
}
