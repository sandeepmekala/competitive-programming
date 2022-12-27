package edu.algos.li15_tree.easy;

import java.util.ArrayList;

import edu.algos.li00_model.TreeNode;

public class L112_PathSum {

	public static void main(String[] args) {
		L112_PathSum obj = new L112_PathSum();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.hasPathSum(root, 6));
		
	}
	
	/*
	 * Problem: https://leetcode.com/problems/path-sum/
	 * Idea: Subtract root value from target sum until it becomes 0 at leave node.
	 * */
	public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null ) return false;
        
        targetSum = targetSum-root.val;
        if(root.left == null && root.right == null && targetSum == 0) 
			return true;
        
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

	public boolean path(TreeNode root, int data, ArrayList<Integer> path){
		if(root == null){
			return false;
		}
		if(data == root.getVal()){
			path.add(root.val);
			return true;
		}
		
		if(path(root.left, data, path)) {
			path.add(root.val);
			return true;
		}
		
		if(path(root.right, data, path)) {
			path.add(root.val);
			return true;
		}
		return false;
	}
	
	public boolean pathSum(TreeNode root, int sum, ArrayList<Integer> path) {
		if(root == null) {
			return false;
		}
		
		if(root.val == sum) {
			path.add(root.val);
			return true;
		}
		
		if(pathSum(root.left, sum-root.val, path)) {
			path.add(root.val);
			return true;
		}
		
		if(pathSum(root.right, sum-root.val, path)) {
			path.add(root.val);
			return true;
		}
		return false;
	}

}
