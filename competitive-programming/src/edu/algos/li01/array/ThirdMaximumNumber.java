package edu.algos.li01.array;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		ThirdMaximumNumber obj = new ThirdMaximumNumber();
		
		int[] nums = new int[] {-2147483648,-2147483648,-2147483648,-2147483648,1,1,1};
		System.out.println(obj.thirdMax(nums));
	}

	/*
	 * Problem: https://leetcode.com/problems/third-maximum-number/
	 * */
	public int thirdMax(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        
        Integer max = null, secondMax = null, thirdMax = null;
        for(Integer num: nums){
            if(num == max || num == secondMax || num == thirdMax) continue;
            
            if(max == null || num > max){
                thirdMax = secondMax;   //n
                secondMax = max;        //-1
                max = num;              //1
            }else if(secondMax == null || num > secondMax){
                thirdMax = secondMax;
                secondMax = num;                
            }else if(thirdMax == null || num > thirdMax){
                thirdMax = num;
            }
        }
        
        if(thirdMax != null ) return thirdMax;
        return max;
    }
}
