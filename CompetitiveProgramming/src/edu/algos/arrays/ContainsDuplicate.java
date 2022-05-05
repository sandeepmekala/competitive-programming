package edu.algos.arrays;

import java.util.HashSet;

public class ContainsDuplicate {

	public static void main(String[] args) {
		ContainsDuplicate obj = new ContainsDuplicate();
		System.out.println(obj.containsDuplicate(new int[] {1,2,3,1}));
		System.out.println(obj.containsDuplicate(new int[] {1,2,3,4}));
	}
	
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
