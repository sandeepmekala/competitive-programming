package edu.algos.li15_tree.medium;

import edu.algos.li00_model.TreeNode;

public class _Bst_L98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        _Bst_L98_ValidateBinarySearchTree obj = new _Bst_L98_ValidateBinarySearchTree();

        _Bst_L701_InsertIntoABinarySearchTree bst = new _Bst_L701_InsertIntoABinarySearchTree();
        TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);

        System.out.println(obj.isValidBST(root));
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
