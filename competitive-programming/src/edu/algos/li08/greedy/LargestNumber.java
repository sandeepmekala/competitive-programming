package edu.algos.li08.greedy;

import java.util.Arrays;

public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber obj = new LargestNumber();
		
		int[] nums = new int[] {3,30,34,5,9};
		System.out.println(obj.largestNumber(nums));
	}

	/*
	 * Problem: https://leetcode.com/problems/largest-number/
	 * Companies: Amazon
	 * */
	public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
		for(int i=0; i<nums.length; i++) {
			numsStr[i] = String.valueOf(nums[i]);
		}
		Arrays.sort(numsStr, (n1, n2) -> (n2+n1).compareTo((n1+n2)));
        
        if(numsStr[0].equals("0")) return "0";
        return String.join("", numsStr);
    }
}
