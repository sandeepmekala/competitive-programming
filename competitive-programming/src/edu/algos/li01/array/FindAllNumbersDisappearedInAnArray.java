package edu.algos.li01.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		FindAllNumbersDisappearedInAnArray obj = new FindAllNumbersDisappearedInAnArray();
		
		int[] nums = new int[] {4,3,2,7,8,2,3,1};
		System.out.println(obj.findDisappearedNumbers(nums));
	}
	
	/*
	 * Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
	 * 
	 * */
	public List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0; 
        while(i<nums.length){
            if(i+1 == nums[i]) {
                i++;
                continue;
            }else{
                int ind = nums[i]-1;
                if(nums[i] == nums[ind]){
                    i++;
                } else{
                    int temp = nums[i];
                    nums[i] = nums[ind];
                    nums[ind] = temp;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int j=0; j<nums.length; j++){
            if(j+1 != nums[j]) list.add(j+1);
        }
        return list;
    }

}
