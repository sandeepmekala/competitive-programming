package edu.algos.li15_tree.medium;

import java.util.Stack;

import edu.algos.li00_model.TreeNode;

class L173_BinarySearchTreeIterator {

    // Problem: https://leetcode.com/problems/binary-search-tree-iterator/
    // Idea: The first processed element would be left most. 
    // Hence, push all the elements to stack until the left most so that left most is available on top of the stack.
    // While process left most, it won't have any further lefts. Hence, the next processed will be left most in it right child. Push all the elements till left most in its right child.
    private TreeNode next = null;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    public L173_BinarySearchTreeIterator(TreeNode root) {
        this.next = new TreeNode(Integer.MIN_VALUE);
        
        TreeNode curr = root;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    public int next() {
        next = stack.pop();
        TreeNode curr = next.right;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        return next.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}