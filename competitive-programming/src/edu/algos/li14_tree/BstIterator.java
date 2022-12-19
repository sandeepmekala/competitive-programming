package edu.algos.li14_tree;

import java.util.Stack;

import edu.algos.li00_model.TreeNode;

class BstIterator {
    private TreeNode next = null;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public BstIterator(TreeNode root) {
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