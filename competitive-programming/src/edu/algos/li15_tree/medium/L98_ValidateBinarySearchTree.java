package edu.algos.li15_tree.medium;

import edu.algos.li00_model.TreeNode;

public class L98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        
    }

    // Problem: https://leetcode.com/problems/validate-binary-search-tree/
    // Idea: Pass min and max to all the recursive calls so that all child nodes should be in that range.
    // Because, immediate child might be in order but grand childs might not be in order.
    public boolean isValidBST(TreeNode root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isBst(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }

        return (root.val > min && root.val < max) && isBst(root.left, min, root.val) && isBst(root.right, root.val, max);
    }
}
