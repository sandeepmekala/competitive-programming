package edu.algos.li15_tree;

import java.util.ArrayList;
import java.util.List;

import edu.algos.li30_model.TreeNode;


public class _Bst_L113_PathSumII {

	public static void main(String[] args) {
		_Bst_L113_PathSumII obj = new _Bst_L113_PathSumII();
		
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
     * Idea: Backtracking algo. Add the node to list when node processing started, remove while exiting.
	 * */
    // time: O(n)
    // space: O(n)
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void pathSum(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result) {
        if(root == null)  
            return;
        
        list.add(root.val);
        if(isLeaf(root) && targetSum == root.val)
            result.add(new ArrayList<Integer>(list));
        
        pathSum(root.left, targetSum - root.val, list, result);
        pathSum(root.right, targetSum - root.val, list, result);
        list.remove(list.size()-1);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
