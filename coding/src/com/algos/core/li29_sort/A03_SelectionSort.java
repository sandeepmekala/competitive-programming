package  com.algos.core.li29_sort;

import java.util.Arrays;

public class A03_SelectionSort {

	public static void main(String[] args) {
		A03_SelectionSort ssort = new A03_SelectionSort();
		int[] numbers = {2,7,4,1,5,3};					
		System.out.println(Arrays.toString(numbers));
		ssort.selectionSort(numbers);							
	}

	// Idea: Select min element in each iteration and put it in its correct place
	// Time complexity is O(n^2)
	// Non-stable sorting
	// Space complexity is O(1). Means Inplace sorting.
	public void selectionSort(int[] nums) {
		int n = nums.length;
		for(int i=0; i<n-1; i++){
			int imin = i;
			for(int j=i+1; j<n; j++){
				if(nums[j] < nums[imin]){
					imin = j;
				}
			}
			int temp = nums[imin];
			nums[imin] = nums[i];
			nums[i] = temp;
			System.out.println(Arrays.toString(nums));
		}		
	}

}
