package edu.algos.li02_array;

import java.util.ArrayList;
import java.util.List;

public class L229_MajorityElementII {

	public static void main(String[] args) {
		L229_MajorityElementII obj = new L229_MajorityElementII();
		
		int[] nums = new int[] {2,1,1,3,1,4,5,6};
		System.out.println(obj.majorityElement(nums));
	}

    // Problem: https://leetcode.com/problems/majority-element-ii/description/
    // Idea: Use Moore's Voting algorithm
	public List<Integer> majorityElement(int[] nums) {
        int num1 = -1, num2 = -1, cnt1 = 0, cnt2 = 0, n=nums.length;
        for(int num: nums){
        	if(num == num1){
                cnt1++;
            }else if(num == num2){
                cnt2++;
            }else if(cnt1 == 0){
                num1 = num;
                cnt1 = 1;
            }else if(cnt2 == 0){
                num2 = num;
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        
        cnt1 = 0; cnt2 = 0;
        for(int num: nums){
            if(num == num1){
                cnt1++;
            }else if(num == num2){
                cnt2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if(cnt1 > n/3){
            result.add(num1);
        }
        if(cnt2 > n/3){
            result.add(num2);
        }
        
        return result;
    }
}
