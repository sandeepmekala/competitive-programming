package edu.algos.li01_array;

public class _L169_MajorityElement {

	public static void main(String[] args) {
		_L169_MajorityElement obj = new _L169_MajorityElement();
		
		int[] nums = new int[] {3,2,3};
		System.out.println(obj.majorityElement2(nums));
	}

    // Problem: https://leetcode.com/problems/majority-element/
    // Idea: Moore's Voting algorithm
    public int majorityElement2(int[] nums) {
        int major = -1, count = 0;
        for(int num: nums){
            if(num == major){
                count++;
            } else if(count == 0){
                major = num;
                count++;
            } else{
                count--;
            }
        }

        return major;
    }
    
    // Idea: Divide the array recursively and find the left and right major elements. Loop through the array and find which one is major out of these two.
    public int majorityElement(int[] nums) {
        int[] result = majorityElement(nums, 0, nums.length-1);
        return result[0];
    }
    
    private int[] majorityElement(int[] nums, int start, int end) {
        if(start == end){
            return new int[]{nums[start], 1};
        }
        
        int mid = (start+end)/2;
        int[] left = majorityElement(nums, start, mid);
        int[] right = majorityElement(nums, mid+1, end);
        
        if(left[0] == right[0]){
            return new int[]{left[0], left[1]+right[1]};
        } else {
            int leftCount = 0;
            int rightCount = 0;
            for(int i=start; i<=end; i++){
                if(nums[i] == left[0]) leftCount++;
                if(nums[i] == right[0]) rightCount++;
            }
            if(leftCount > rightCount) return left;
            else return right;
        }
        
    }
}
