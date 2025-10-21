package  com.algos.core.basic;

import java.util.Arrays;
import java.util.Random;

public class A05_QuickSort {

	public static void main(String[] args) {
		A05_QuickSort qsort = new A05_QuickSort();
		int[] numbers = {7,2,1,6,8,5,3,4};
		qsort.quickSort(numbers,0,7);
	}

	// Idea:
	// Time complexity in average case O(nlogn). Worst case is O(n^2)
	// Non stable sorting
	// Space complexity in average case is O(nlogn) and worst case is O(n^2). So, it is not inplace sorting.
	private void quickSort(int[] numbers, int low, int high) {
		if(low >= high){
			return;
		}

		System.out.println(Arrays.toString(numbers));
		int pIndex = partition(numbers, low, high);
		quickSort(numbers, low, pIndex-1);
		quickSort(numbers, pIndex+1, high);
	}
	// Idea: in recursive quicksort only l,h are sorted in stack. In this approach we use stack to push these pointers. If the returned pivot pointer is > then the l then push l, p-1 and vice versa.
	private void iterativeQuickSort() {

	}

	// Idea: just select a random index and put that element at the start
	private int randomizedPartition(int numbers[], int low, int high){
		Random r = new Random();
		int pIndex = r.nextInt(high-low) + low;
		int temp = numbers[pIndex];
		numbers[pIndex] = numbers[low];
		numbers[low] = temp;
		return partition(numbers, low, high);
	}

	private int partition(int[] nums, int low, int high) {
		int n = nums.length;
		int i=low, j=high;
		while(i<j) {
			while(i<n && nums[i] <= nums[low]) {
				i++;
			}
			while(j>=0 && nums[j] > nums[low]) {
				j--;
			}
			if(i<j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		int temp = nums[j];
		nums[j] = nums[low];
		nums[low] = temp;

		return j;
	}

}
