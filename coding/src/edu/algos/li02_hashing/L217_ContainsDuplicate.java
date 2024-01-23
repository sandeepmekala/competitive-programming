package edu.algos.li02_hashing;

import java.util.HashSet;

public class L217_ContainsDuplicate {

	public static void main(String[] args) {
		L217_ContainsDuplicate obj = new L217_ContainsDuplicate();
		System.out.println(obj.containsDuplicate(new int[] {1,2,3,1}));
		System.out.println(obj.containsDuplicate(new int[] {1,2,3,4}));
	}
	
    // Problem: https://leetcode.com/problems/contains-duplicate/
    // Idea: Use Set to check duplicates
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
