package edu.algos.li14.tree;

import java.util.HashSet;

import edu.algos.li00.model.TreeNode;

public class TwoSumIvInputIsABst {

	public static void main(String[] args) {
		TwoSumIvInputIsABst obj = new TwoSumIvInputIsABst();
		
		BinarySearchTree bst = new BinarySearchTree();
		TreeNode root = bst.insert(null, 10);
		bst.insert(root, 2);
		bst.insert(root, 4);
		bst.insert(root, 6);
		bst.insert(root, 5);
		bst.insert(root, 15);
		bst.insert(root, 3);
		
		System.out.println(obj.findTarget(root, 10));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
	 * 
	 * */
	public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }
    
    private boolean findTarget(TreeNode root, int k, HashSet<Integer> set) {
        if(root == null) return false;
        
        if(set.contains(k-root.val)) return true;
        else set.add(root.val);
        
        return findTarget(root.left, k, set) || findTarget(root.right, k, set);
    }

}
