package edu.algos.li07.divandcon;

import java.util.ArrayList;

public class ReversePairs {

	public static void main(String[] args) {
		ReversePairs obj = new ReversePairs();
		
		int[] nums = new int[] {1,3,2,3,1};
		System.out.println(obj.reversePairs(nums));
	}

	public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    
    private int mergeSort(int[] nums, int low, int high) {
		if(low >= high){
			return 0;
		}
		int mid = (low+high)/2;
		int pairs = mergeSort(nums, low, mid);
		pairs += mergeSort(nums, mid+1, high);
		pairs += merge(nums, low, mid, high);
        
        return pairs;
	}
	private int merge(int nums[], int low, int mid, int high){
		int left = low;
		int right = mid+1;
		
        int pairs = 0;
        int j=mid+1;
        for(int i=low; i<=mid; i++){
        	while(j<=high && nums[i] > (long)2*nums[j]) j++;
            
            pairs += j-(mid+1);
        }
        
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
        
        return pairs;
	} 
}
