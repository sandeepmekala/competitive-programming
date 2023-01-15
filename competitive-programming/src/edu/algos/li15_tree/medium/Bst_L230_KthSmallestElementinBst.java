package edu.algos.li15_tree.medium;

import java.util.Stack;

import edu.algos.li00_model.TreeNode;

public class Bst_L230_KthSmallestElementinBst {

	public static void main(String[] args) {
		Bst_L230_KthSmallestElementinBst obj = new Bst_L230_KthSmallestElementinBst();
		Bst_L701_InsertIntoABinarySearchTree bst = new Bst_L701_InsertIntoABinarySearchTree();
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
    // You can use morris traversal to reduce the space.
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        int count = 0;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else{
                current = stack.pop();
                count++;
                if(count == k){
                    return current.val;
                }
                current = current.right;
            }
        }

        return -1;
    }
}
