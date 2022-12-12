package edu.algos.li14.tree;

import edu.algos.li00_model.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		obj.flatten(root);
		bt.inorder(root);
	}

	/*
	 * Problem: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
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
