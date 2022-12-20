package edu.algos.li15_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import edu.algos.li00_model.TreeNode;

public class FindModeInBinarySearchTree {

	public static void main(String[] args) {
		FindModeInBinarySearchTree obj = new FindModeInBinarySearchTree();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 2, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		int[] result = obj.findMode(root);
		System.out.println(Arrays.toString(result));		
	}

	/*
	 * Problem: https://leetcode.com/problems/find-mode-in-binary-search-tree/
	 * 
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
