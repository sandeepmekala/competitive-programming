package edu.algos.li17_backtracking;

import java.util.ArrayList;
import java.util.List;

import edu.algos.li00_model.TreeNode;


public class PathSumII {

	public static void main(String[] args) {
		PathSumII obj = new PathSumII();
		
				TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		System.out.println(obj.pathSum(root, 6));
	}

	/*
	 * Problem: https://leetcode.com/problems/path-sum-ii/
	 * Companies: Amazon
	 * */
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void pathSum(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result) {
        if(root == null) return;
        
        list.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val){
            result.add(new ArrayList<Integer>(list));
        }
        pathSum(root.left, targetSum - root.val, list, result);
        pathSum(root.right, targetSum - root.val, list, result);
        list.remove(list.size()-1);
    }
}
