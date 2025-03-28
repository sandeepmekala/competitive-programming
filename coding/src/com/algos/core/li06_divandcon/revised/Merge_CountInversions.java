package  com.algos.core.li06_divandcon.revised;

import java.util.ArrayList;
import java.util.List;

public class Merge_CountInversions {

	public static void main(String[] args) {
		Merge_CountInversions obj = new Merge_CountInversions();
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
		int mid = (low+high)/2, cnt = 0;
		cnt += mergeSortAndCount(nums, low, mid);
		cnt += mergeSortAndCount(nums, mid+1, high);
		cnt += merge(nums, low, mid, high);

		return cnt;
	}
	private int merge(int nums[], int low, int mid, int high){
		int left = low;
		int right = mid+1;
		int cnt = 0;
		
		List<Integer> temp = new ArrayList<>();
		while(left <= mid && right <= high){
			if(nums[left] <= nums[right]){
				temp.add(nums[left++]);
			}else{							// a[i] > a[j]
				temp.add(nums[right++]);

				cnt += mid-left+1;		// inversion count
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

		return cnt;
	}

}
