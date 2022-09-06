package edu.algos.li14.tree;

import edu.algos.li00.model.TreeNode;

public class ConvertBstToGreaterTree {

	public static void main(String[] args) {
		ConvertBstToGreaterTree obj = new ConvertBstToGreaterTree();
		
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = bst.insert(null, 10);
		bst.insert(root, 2);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 5);
		bst.insert(root, 15);
		bst.insert(root, 3);
		
		System.out.println(obj.convertBST(root));
	}

	/*
	 * Problem: https://leetcode.com/problems/convert-bst-to-greater-tree/
	 * Companies: Amazon
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
