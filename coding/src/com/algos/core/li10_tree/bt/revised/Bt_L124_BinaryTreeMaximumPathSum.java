package  com.algos.core.li10_tree.bt.revised;

import  com.algos.core.li30_model.TreeNode;

public class Bt_L124_BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Bt_L124_BinaryTreeMaximumPathSum obj = new Bt_L124_BinaryTreeMaximumPathSum();

        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);

        System.out.println(obj.maxPathSum(root));
    }

    // Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/
    // Idea: Idea is similar to finding max diameter. 
    // In paths, we can ignore the negative sum paths by taking max with 0 to skip negative path sums.
    public int maxPathSum(TreeNode root) {
        int[] maxPathSum = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, maxPathSum);
        return maxPathSum[0];
    }
    
    private int maxPathSum(TreeNode root, int[] maxPathSum){
        if(root == null)
            return 0;
        
        int leftSum = Math.max(0, maxPathSum(root.left, maxPathSum));
        int rightSum = Math.max(0, maxPathSum(root.right, maxPathSum));
        int pathSum = root.val+leftSum+rightSum;
        maxPathSum[0] = Math.max(maxPathSum[0], pathSum);

        return root.val+Math.max(leftSum, rightSum);
    }
}
