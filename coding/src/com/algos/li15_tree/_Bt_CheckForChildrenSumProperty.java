package edu.algos.li15_tree;

import edu.algos.li30_model.TreeNode;

public class _Bt_CheckForChildrenSumProperty {
    public static void main(String[] args) {
        //Bt_CheckForChildrenSumProperty obj = new Bt_CheckForChildrenSumProperty();
    
    }

    // time: O(n)
    // space: O(1)
    static void changeTree(TreeNode root) {
        if (root == null)
            return;

        int childSum = 0;
        if (root.left != null) childSum += root.left.val;
        if (root.right != null) childSum += root.right.val;

        if (childSum < root.val) {
            if (root.left != null) root.left.val = root.val;
            else if (root.right != null) root.right.val = root.val;
        }

        changeTree(root.left);
        changeTree(root.right);

        int totalSum = 0;
        if (root.left != null) totalSum += root.left.val;
        if (root.right != null) totalSum += root.right.val;

        if (root.left != null || root.right != null)
            root.val = totalSum;
    }
}
