package edu.algos.li15_tree.easy;

import edu.algos.li00_model.TreeNode;
import edu.algos.li15_tree.medium.L701_InsertIntoABinarySearchTree;

public class L700_SearchInABinarySearchTree {
    public static void main(String[] args) {
        L700_SearchInABinarySearchTree obj = new L700_SearchInABinarySearchTree();
        
        L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
        TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);

        System.out.println(obj.searchBST(root, 4));        
    }

    // Problem: https://leetcode.com/problems/search-in-a-binary-search-tree/
    // Idea: If val < root, search in left subtree else search in right subtree.
    public TreeNode searchBST(TreeNode  root, int data){
		if(root == null || root.val == data)
			return root;
		
		if(data < root.val){
			return searchBST(root.left, data);
		}else{
			return searchBST(root.right, data);
		}
	}
}
