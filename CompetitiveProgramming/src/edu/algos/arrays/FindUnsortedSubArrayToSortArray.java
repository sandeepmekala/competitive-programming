package edu.algos.arrays;

public class FindUnsortedSubArrayToSortArray {

	// https://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-makes-the-complete-array-sorted/
	// check from both sides and stop when sort is invalid
	// check remaining unsorted array and move the pointers backward if you see any element smaller then max element of left sorted array and vice version for right array pointer
	public static void main(String[] args) {
		int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		
		int leftMax = -1;
		int rightMin = -1;
		int leftIndex = 0;
		int rightIndex = arr.length;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i+1] < arr[i]) {
				leftIndex = i+1;
				leftMax = arr[i];
				break;
			}
		}
		if(leftIndex == 0) {
			System.out.println("Array is already sorted");
			return;
		}
		for(int i=arr.length-1; i>0; i--) {
			if(arr[i-1] > arr[i]) {
				rightIndex = i-1;
				rightMin = arr[i];
				break;
			}
		}

		System.out.println("Array starts from index "+leftMax+" and ends at index "+rightMin);
		int tempRightIndex = rightIndex;
		for(int i=leftIndex; i<=tempRightIndex; i++) {
			if(arr[i] < leftMax) {
				leftIndex--;
			}
			if(arr[i] > rightMin) {
				rightIndex++;
			}
		}
		
		System.out.println("Array starts from index "+leftIndex+" and ends at index "+rightIndex);
	}

}
