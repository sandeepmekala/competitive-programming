package edu.algos.li15_tree.medium;

import java.util.Stack;

import edu.algos.li00_model.TreeNode;

public class L230_KthSmallestElementinBst {

	public static void main(String[] args) {
		L230_KthSmallestElementinBst obj = new L230_KthSmallestElementinBst();
		L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
		TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);
		
		System.out.println(obj.kthSmallest(root, 3));

	}

    // Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    // Idea: Traverse the BST using iterative inorder and return when count == k.
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        int count = 0;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;
            if(count == k){
                return current.val;
            }
            current = current.right;
        }

        return count;
    }
}
