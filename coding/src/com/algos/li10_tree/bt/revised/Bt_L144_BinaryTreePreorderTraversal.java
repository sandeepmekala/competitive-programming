package  com.algos.li10_tree.bt.revised;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import  com.algos.li30_model.TreeNode;

public class Bt_L144_BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Bt_L144_BinaryTreePreorderTraversal obj = new Bt_L144_BinaryTreePreorderTraversal();
        
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
	// Time: O(n)
    // Space: O(1)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        return preorder;
    }
    
    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if(root == null)
			return;
        
		list.add(root.val);
		preorderTraversal(root.left, list);
		preorderTraversal(root.right, list);
    }

    // Use stack to compensate for recursion
    // Push right, left to stack as we need to explore left first.
	// Time: O(n)
    // space: O(1)
	public List<Integer> preorderIterative(TreeNode root) {
		if(root == null) 
			return new ArrayList<>();
        
        List<Integer> preorder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) { 
			TreeNode curr = stack.pop();
			preorder.add(curr.val);
			if(curr.right != null) 
				stack.add(curr.right);
			if(curr.left != null) 
				stack.add(curr.left);
		}

        return preorder;
	}

    public List<Integer> morrisPreorder(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
		TreeNode curr = root;
		while(curr != null) {
			if(curr.left == null) {
                preorder.add(curr.val);
				curr = curr.right;
			}else {
				TreeNode prev = curr.left;
				while(prev.right != null && prev.right != curr) { 
					prev = prev.right;
				}
				if(prev.right == null) {
					prev.right = curr;
					preorder.add(curr.val);      // one line change from inorder. 
					curr = curr.left;
				}else {
					prev.right = null;
					curr = curr.right;
				}
			}
		}

        return preorder;
	}
}
