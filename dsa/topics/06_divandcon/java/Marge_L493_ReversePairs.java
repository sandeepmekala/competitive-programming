import java.util.ArrayList;

public class Marge_L493_ReversePairs {

	public static void main(String[] args) {
		Marge_L493_ReversePairs obj = new Marge_L493_ReversePairs();

		int[] nums = new int[] {1,3,2,3,1};
		System.out.println(obj.reversePairs(nums));
	}

	// Problem: https://leetcode.com/problems/reverse-pairs/
	// Idea: Use merge sort approach. Two sorted arrays are used to calculate pairs. For every element in arr1, check matching pairs in arr2.
	// Pairs from arr1 and arr2 are calculated recursively. Pairs for arr1 and arr2 combined is calculated before merge process.
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
		// Calculate pairs
		int pairs = 0;
        for(int i=low, j=mid+1; i<=mid; i++){
			while(j<=high && nums[i] > (long)2*nums[j])
				j++;

            pairs += j-(mid+1);
        }

		// Merge arrays
		int left = low, right = mid+1;
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
