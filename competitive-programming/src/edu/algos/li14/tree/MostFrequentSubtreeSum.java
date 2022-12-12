package edu.algos.li14.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import edu.algos.li00_model.TreeNode;

public class MostFrequentSubtreeSum {

	public static void main(String[] args) {
		MostFrequentSubtreeSum obj = new MostFrequentSubtreeSum();
		
		BinaryTree bt = new BinaryTree();
		TreeNode root = bt.insert(null, 1, null);
		TreeNode n1 = bt.insert(root, 3, "l");
		TreeNode n2 = bt.insert(root, 4, "r");
		TreeNode n3 = bt.insert(n1, 2, "l");
		TreeNode n4 = bt.insert(n1, 6, "r");
		TreeNode n5 = bt.insert(n4, 5, "l");
		
		int[] result = obj.findFrequentTreeSum(root);
		System.out.println(Arrays.toString(result));
	}

	/*
	 * Problem: https://leetcode.com/problems/most-frequent-subtree-sum/
	 * Companies: Amazon
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
