package edu.algos.li14.tree;

import edu.algos.li00.model.TreeNode;

public class SumRootToLeafNumbers {

	public static void main(String[] args) {
		SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		System.out.println(obj.sumNumbers(root));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/
	 * Companies: Amazon
	 * */
	public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int sum){
        if(root == null) return 0;
        
        if(root.left == null && root.right == null) return sum*10+root.val;
        
        return sumNumbers(root.left, sum*10+root.val) + sumNumbers(root.right, sum*10+root.val);
    }

}
