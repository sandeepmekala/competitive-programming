package  com.algos.li10_tree.bst.revised;

import  com.algos.li30_model.TreeNode;

public class L98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        L98_ValidateBinarySearchTree obj = new L98_ValidateBinarySearchTree();

        L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
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
    // Time: O(n)
    // space: O(1)
    public boolean isValidBST(TreeNode root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isBst(TreeNode root, long min, long max){
        if(root == null)
            return true;

        return (root.val > min && root.val < max) && isBst(root.left, min, root.val) && isBst(root.right, root.val, max);
    }
}
