package edu.algos.li07_divandcon;

import java.util.ArrayList;

public class A01_MergeSort_CountInversionInArray {

	public static void main(String[] args) {
		A01_MergeSort_CountInversionInArray obj = new A01_MergeSort_CountInversionInArray();
		int[] arr = { 5,3,2,4,1};
		
		System.out.println(obj.mergeSortAndCount(arr, 0, arr.length-1));
	}
	
	// Problem: https://www.geeksforgeeks.org/counting-inversions/?ref=lbp
	// Idea: Use merge sort. While merging if left num is greater then right num, then that is the possible pair. 
	// All the nums right side of left will form a pair with right num.
	public int mergeSortAndCount(int[] nums, int low, int high) {
		if(low >= high){
			return 0;
		}
		int mid = (low+high)/2, count = 0;
		count += mergeSortAndCount(nums, low, mid);
		count += mergeSortAndCount(nums, mid+1, high);
		count += merge(nums, low, mid, high);

		return count;
	}
	private int merge(int nums[], int low, int mid, int high){
		int left = low;
		int right = mid+1;
		int count = 0;
		
		ArrayList<Integer> temp = new ArrayList<>();
		while(left <= mid && right <= high){
			if(nums[left] <= nums[right]){
				temp.add(nums[left++]);
			}else{
				temp.add(nums[right++]);

				count += mid-left+1;		// inversion count
			}
		}
		while(left <= mid){
			temp.add(nums[left++]);
		}
		while(right <= high){
			temp.add(nums[right++]);
		}
		
		for(int i=low; i<=high; i++) {
			nums[i] = temp.get(i-low);
		}

		return count;
	}

}
