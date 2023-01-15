package edu.algos.li15_tree.medium;

import edu.algos.li00_model.TreeNode;

public class L538_ConvertBstToGreaterTree {

	public static void main(String[] args) {
		L538_ConvertBstToGreaterTree obj = new L538_ConvertBstToGreaterTree();
		
		Bst_L701_InsertIntoABinarySearchTree bst = new Bst_L701_InsertIntoABinarySearchTree();
		TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);
		
		System.out.println(obj.convertBST(root));
	}

	/*
	 * Problem: https://leetcode.com/problems/convert-bst-to-greater-tree/
	 * Companies: Amazon
	 * Idea: We need to process right first, get the rightSum, then update the root val as root+rightSum, then process left. 
	 * Left child should get the sum its root+rightSum. Hence, we need to pass a sum varible.
	 *  
	 * */
	public TreeNode convertBST(TreeNode root) {
        convertBst(root, 0);

        return root;
    }
    
    private int convertBst(TreeNode root, int sum){
        if(root == null) return sum;
        
        int rightSum = convertBst(root.right, sum);
        root.val = rightSum + root.val;
        return convertBst(root.left, root.val);
    }
}
