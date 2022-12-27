package edu.algos.li15_tree.medium;

import edu.algos.li00_model.TreeNode;

public class L701_InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        L701_InsertIntoABinarySearchTree obj = new L701_InsertIntoABinarySearchTree();

		TreeNode root = obj.insertIntoBST(null, 10);
		obj.insertIntoBST(root, 2);
		obj.insertIntoBST(root, 4);
		obj.insertIntoBST(root, 6);
		obj.insertIntoBST(root, 5);
		obj.insertIntoBST(root, 15);
		obj.insertIntoBST(root, 3);

        System.out.println(root);
    }

    // Problem: https://leetcode.com/problems/insert-into-a-binary-search-tree/
	// Idea: If val < root, insert in left subtree else insert in right subtree.
    public TreeNode insertIntoBST(TreeNode  root, int data){
		if(root == null){
			return new TreeNode(data);
		}else{
			if(data < root.val){
				root.left = insertIntoBST(root.left, data);
			}else{
				root.right = insertIntoBST(root.right, data);
			}

            return root;
		}
	}
}
