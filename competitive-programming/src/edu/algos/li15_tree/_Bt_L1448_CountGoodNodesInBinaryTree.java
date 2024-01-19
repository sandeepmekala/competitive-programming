package edu.algos.li15_tree;

import edu.algos.li30_model.TreeNode;


public class _Bt_L1448_CountGoodNodesInBinaryTree {

	public static void main(String[] args) {
		_Bt_L1448_CountGoodNodesInBinaryTree obj = new _Bt_L1448_CountGoodNodesInBinaryTree();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.goodNodes(root));
	}
	
    // Problem: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
    // Idea: You need to track and pass the max value in each path recursive calls in top down.
	public int goodNodes(TreeNode root) {
        return goodNodesRec(root, Integer.MIN_VALUE);
    }
    
    private int goodNodesRec(TreeNode root, int max){
        if(root == null)
            return 0;

        int count = 0;
        if(root.val >= max){
            count++;
            max = root.val;
        }

        return count + goodNodesRec(root.left, max) + goodNodesRec(root.right, max);
    }

}
