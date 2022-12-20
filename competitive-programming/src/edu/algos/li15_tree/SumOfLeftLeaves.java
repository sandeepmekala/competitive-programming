package edu.algos.li15_tree;

import edu.algos.li00_model.TreeNode;

public class SumOfLeftLeaves {

	public static void main(String[] args) {
		SumOfLeftLeaves obj = new SumOfLeftLeaves();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.sumOfLeftLeaves(root));
		
	}
	
	/*
	 * Problem: https://leetcode.com/problems/sum-of-left-leaves/
	 * 
	 * */
	public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }
    
    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) 
            if(isLeft) return root.val;
            else return 0;
        
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

}
