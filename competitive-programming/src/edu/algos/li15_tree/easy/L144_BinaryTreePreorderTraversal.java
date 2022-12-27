package edu.algos.li15_tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.algos.li00_model.TreeNode;

public class L144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        L144_BinaryTreePreorderTraversal obj = new L144_BinaryTreePreorderTraversal();
        
        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.preorderTraversal(root));
    }

    // Problem: https://leetcode.com/problems/binary-tree-preorder-traversal
    // Idea: rt-l-r
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }
    
    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if(root != null){
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    // Use stack to compensate for recursion
	public List<Integer> preorderIterative(TreeNode root) {
		if(root == null) {
			return new ArrayList<>();
		}
        
        List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode current = stack.pop();
			list.add(current.val);
			if(current.right != null) {
				stack.add(current.right);
			}
			if(current.left != null) {
				stack.add(current.left);
			}
		}

        return list;
	}
}
