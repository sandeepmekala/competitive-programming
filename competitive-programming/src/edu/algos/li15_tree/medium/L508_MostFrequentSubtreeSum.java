package edu.algos.li15_tree.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.algos.li00_model.TreeNode;


public class L508_MostFrequentSubtreeSum {

	public static void main(String[] args) {
		L508_MostFrequentSubtreeSum obj = new L508_MostFrequentSubtreeSum();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(5);
		
		int[] result = obj.findFrequentTreeSum(root);
		System.out.println(Arrays.toString(result));
	}

	/*
	 * Problem: https://leetcode.com/problems/most-frequent-subtree-sum/
	 * Companies: Amazon
     * Idea: root.val+left+right is treesum. Store the treeSum's of each node in a map and track max.
	 * */
	public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] max = new int[]{0};
        findFrequentTreeSum(root, map, max);
        
        List<Integer> list = new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key) == max[0])
                list.add(key);
        }
        
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = list.get(i);
        }
        
        return result;
        
    }
    
    private int findFrequentTreeSum(TreeNode root, HashMap<Integer, Integer> map, int[] max) {
        if(root == null) return 0;
        
        int left = findFrequentTreeSum(root.left, map, max);
        int right = findFrequentTreeSum(root.right, map, max);
        int sum = root.val+left+right;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        max[0] = Math.max(max[0], map.get(sum));

        return sum;
    }
}
