package edu.algos.li06.binarysearch;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		SplitArrayLargestSum obj = new SplitArrayLargestSum();
		
		int[] nums = new int[] {7,2,5,10,8};
		System.out.println(obj.splitArray(nums, 2));
	}

	/*
	 * Problem: https://leetcode.com/problems/split-array-largest-sum/
	 * Companies: Amazon
	 * */
	public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        
        int l = max, r = sum, res = sum;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(valid(nums, mid, m)){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return res;
    }
    
    private boolean valid(int[] nums, int mid, int m){
        int sum = 0;
        for(int num: nums){
            if(sum+num <= mid){
                sum += num;
            }else{
                m--;
                sum = num;
            }
        }
        
        return m>0;
    }
}
