package edu.algos.li15_tree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.algos.li00_model.TreeNode;

public class L145_BinaryTreePostorderTraversal {
    
    public static void main(String[] args) {
        L145_BinaryTreePostorderTraversal obj = new L145_BinaryTreePostorderTraversal();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.postorderTraversal(root));
        System.out.println(obj.postorderIterativeTwoStacks(root));
        //System.out.println(obj.postorderIterativeOneStack(root));
    }

    // Problem: https://leetcode.com/problems/binary-tree-postorder-traversal/
    // l-r-rt
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }
    
    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if(root != null){
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }

    public List<Integer> postorderIterativeTwoStacks(TreeNode root) {
		if(root == null) {
			return new ArrayList<>();
		}
		
        List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while(!stack1.isEmpty()) {
			TreeNode current = stack1.pop();
			stack2.push(current);
			if(current.left != null) stack1.push(current.left);
			if(current.right != null) stack1.push(current.right);
		}
		
		while(!stack2.isEmpty()) {
			TreeNode current = stack2.pop();
			list.add(current.val);
		}

        return list;
	}

	// public List<Integer> postorderIterativeOneStack(TreeNode root) {
	// 	if(root == null) {
	// 		return new ArrayList<Integer>();
	// 	}
		
    //     List<Integer> list = new ArrayList<Integer>();
	// 	Stack<TreeNode> stack = new Stack<TreeNode>();
	// 	TreeNode current = root;
	// 	while(!stack.isEmpty() || current != null) {
	// 		if(current != null) {
	// 			stack.push(current);
	// 			current = current.left;
	// 		}
			
    //         TreeNode right = stack.peek().right;
    //         if(right == null || right == stack.peek().right) {
    //             list.add(stack.pop().val);
    //         }else {
    //             current = right;
    //         }
	// 	}

    //     return list;
	// }
}
