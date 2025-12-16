
public class L581_ShortestUnsortedContinuousSubarray {

	public static void main(String[] args) {
		L581_ShortestUnsortedContinuousSubarray obj = new L581_ShortestUnsortedContinuousSubarray();

		int arr[] = {2,6,4,8,10,9,15};
		//int arr[] = {2,1,3};
		//int arr[] = {1,2,3,4,5};
		//int arr[] = {1,3,5,4,2};
		System.out.println(obj.findUnsortedSubarray(arr));

	}

	/*
	 * Problem: https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
	 * Companies; Amazon
	 * Idea: Find the min and max in unsorted part of the array. Find the indices where those fits in second traversal.
	 * */
	public int findUnsortedSubarray(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=1; i<nums.length; i++) {
			if(nums[i] < nums[i-1]) {
				min = Math.min(min, nums[i]);		//find the min if sort order not follow
			}
		}
		if(min == Integer.MAX_VALUE) return 0;

		for(int j=nums.length-2; j>=0; j--) {
			if(nums[j] > nums[j+1]) {
				max = Math.max(max, nums[j]);
			}
		}

        int left = 0, right = nums.length;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] > min) {
				left = i;
				break;
			}
		}
		for(int j=nums.length-1; j>=0; j--) {
			if(nums[j] < max) {
				right = j;
				break;
			}
		}

		return right-left+1;
    }
}
