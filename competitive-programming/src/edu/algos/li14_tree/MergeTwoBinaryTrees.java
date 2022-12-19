package edu.algos.li14_tree;

import edu.algos.li00_model.TreeNode;

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		MergeTwoBinaryTrees obj = new MergeTwoBinaryTrees();
		
		BinarySearchTree bst1 = new BinarySearchTree();
		TreeNode root1 = bst1.insert(null, 10);
		bst1.insert(root1, 2);
		bst1.insert(root1, 4);
		bst1.insert(root1, 6);
		bst1.insert(root1, 5);
		bst1.insert(root1, 15);
		bst1.insert(root1, 3);
		
		BinarySearchTree bst2 = new BinarySearchTree();
		TreeNode root2 = bst2.insert(null, 10);
		bst2.insert(root2, 2);
		bst2.insert(root2, 4);
		bst2.insert(root2, 6);
		bst2.insert(root2, 5);
		bst2.insert(root2, 15);
		bst2.insert(root2, 3);
		
		obj.mergeTrees(root1, root2);
		bst1.inorder(root1);
	}

	/*
	 * Problem: https://leetcode.com/problems/merge-two-binary-trees/
	 * 
	 * */
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        else if(root1 == null) return root2;
        else if(root2 == null) return root1;
        else{
            root1.val = root1.val+root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }
}
