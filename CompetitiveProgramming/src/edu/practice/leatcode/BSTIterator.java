package edu.practice.leatcode;

import java.util.Stack;

import edu.ds.trees.model.TreeNode;

class BSTIterator {
    private TreeNode next = null;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        this.next = new TreeNode(Integer.MIN_VALUE);
        
        TreeNode current = root;
        while(current != null){
            stack.push(current);
            current = current.left;
        }
    }
    
    public int next() {
        next = stack.pop();
        TreeNode current = next.right;
        while(current != null){
            stack.push(current);
            current = current.left;
        }
        return next.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}