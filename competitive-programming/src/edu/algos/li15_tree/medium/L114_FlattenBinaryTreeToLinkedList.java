package edu.algos.li15_tree.medium;

import edu.algos.li00_model.TreeNode;


public class L114_FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		L114_FlattenBinaryTreeToLinkedList obj = new L114_FlattenBinaryTreeToLinkedList();
		
				TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		obj.flatten(root);
		//bt.inorder(root);
	}

	/*
	 * Problem: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
	 * Idea: Idea is to traverse in reverse preorder and flatten
	 * Use a global prev variable to track the last explored node in preorder traversal and assign it to right of current node.Then update the current as next previous for next iteration.
	 * You can use Morris traversal to implement the same in interative mannar
	 *  
	 * */
	TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        flatten(root.right);
        flatten(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
