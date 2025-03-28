package  com.algos.core.li10_tree.bst;

import com.algos.core.li10_tree.bst.revised.L701_InsertIntoABinarySearchTree;
import  com.algos.core.li30_model.TreeNode;

public class Bst_L530_MinimumAbsoluteDifferenceInBst {

	public static void main(String[] args) {
		Bst_L530_MinimumAbsoluteDifferenceInBst obj = new Bst_L530_MinimumAbsoluteDifferenceInBst();
		
		L701_InsertIntoABinarySearchTree bst = new L701_InsertIntoABinarySearchTree();
		TreeNode root = bst.insertIntoBST(null, 10);
		bst.insertIntoBST(root, 2);
		bst.insertIntoBST(root, 4);
		bst.insertIntoBST(root, 6);
		bst.insertIntoBST(root, 5);
		bst.insertIntoBST(root, 15);
		bst.insertIntoBST(root, 3);
		
		System.out.println(obj.getMinimumDifference(root));
	}

	/*
	 * Problem: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
	 * Idea: Process inorder, and track prev element. Find the difference between root.val and prev.	 
	 * */
	int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) 
			return Integer.MAX_VALUE;
        
        int left = getMinimumDifference(root.left);
        int diff = Math.abs(prev - root.val);
        prev = root.val;
        int right = getMinimumDifference(root.right);
                                                
        return Math.min(diff, Math.min(left, right));
                                              
    }
}
