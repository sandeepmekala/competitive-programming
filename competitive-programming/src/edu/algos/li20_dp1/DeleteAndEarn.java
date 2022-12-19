package edu.algos.li20_dp1;

import java.util.HashMap;

public class DeleteAndEarn {

	public static void main(String[] args) {
		DeleteAndEarn obj = new DeleteAndEarn();
		
		int[] nums = new int[] {2,2,3,3,3,4};
		System.out.println(obj.deleteAndEarn(nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/delete-and-earn/
	 * Companies: Amazon
	 * */
	public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            max = Math.max(max, num);
            map.put(num, map.getOrDefault(num, 0)+num);
        }
        
        int[] tab = new int[max+1];
        tab[1] =  map.getOrDefault(1, 0);
        for(int i=2; i<=max; i++){
            tab[i] = Math.max(map.getOrDefault(i, 0)+tab[i-2], tab[i-1]);
        }
        
        return tab[max];
    }

}
