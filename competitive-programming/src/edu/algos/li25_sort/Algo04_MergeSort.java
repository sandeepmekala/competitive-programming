package edu.algos.li25_sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Algo04_MergeSort {

	public static void main(String[] args) {
		Algo04_MergeSort msort = new Algo04_MergeSort();
		
		int[] nums = {2,4,1,6,8,5,3,7};					
		msort.mergeSort(nums, 0, nums.length-1);									
	}
	
	//Idea: divide array into two arrays(copied) and call mergeSort recursively for other 2 half then call merge
	//time complexity is worst case O(nlogn)
	//stable sorting
	//space complexity is O(n) if we clear the unused memory during runtime. it will be O(nlogn) if we don't clear the space during runtime. So, it is not inplace sorting.
	private void mergeSort(int[] nums, int low, int high) {
		if(low >= high){
			return;
		}
		int mid = (low+high)/2;
		mergeSort(nums, low, mid);
		mergeSort(nums, mid+1, high);
		merge(nums, low, mid, high);
	}
	private void merge(int nums[], int low, int mid, int high){
		int left = low;
		int right = mid+1;
		
		ArrayList<Integer> temp = new ArrayList<>();
		while(left <= mid && right <= high){
			if(nums[left] <= nums[right]){
				temp.add(nums[left++]);
			}else{
				temp.add(nums[right++]);
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
		System.out.println(Arrays.toString(nums));
	} 

}
