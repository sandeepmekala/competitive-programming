package edu.algos.li17_backtracking;

import java.util.ArrayList;
import java.util.List;

import edu.algos.li00_model.TreeNode;
import edu.algos.li15_tree.BinaryTree;

public class PathSumII {

	public static void main(String[] args) {
		PathSumII obj = new PathSumII();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
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
