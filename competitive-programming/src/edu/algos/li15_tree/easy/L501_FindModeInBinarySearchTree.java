package edu.algos.li15_tree.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import edu.algos.li00_model.TreeNode;

public class L501_FindModeInBinarySearchTree {

	public static void main(String[] args) {
		L501_FindModeInBinarySearchTree obj = new L501_FindModeInBinarySearchTree();
		
        TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		int[] result = obj.findMode(root);
		System.out.println(Arrays.toString(result));		
	}

	/*
	 * Problem: https://leetcode.com/problems/find-mode-in-binary-search-tree/
	 * Idea: Traverse the BST in preorder and find counts and max.
     * TODO
	 * */
	int max = 0;
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        preorder(root, map);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int key: map.keySet()){
            if(max == map.get(key)) list.add(key);
        }
        
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
    }
    
    private void preorder(TreeNode root, HashMap<Integer, Integer> map){
        if(root != null){
            int val = root.val;
            map.put(val, map.getOrDefault(val, 0)+1);
            max = Math.max(max, map.get(val));
            preorder(root.left, map);
            preorder(root.right, map);
        }
    }
}
