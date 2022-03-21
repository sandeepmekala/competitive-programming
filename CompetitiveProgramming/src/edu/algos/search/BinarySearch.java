package edu.algos.search;

public class BinarySearch {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;	

		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(arr, 0, n-1, x));
	}

	// concept: divide the array in half every based on if mid element is greater or smaller
	private int search(int[] numbers, int start, int end, int x) {
		
		if (start <= end) {
			// find mid
			int mid = (start + end) / 2;
			if (numbers[mid] == x) {
				return mid;
			}

			if (x <= numbers[mid]) {
				return search(numbers, start, mid - 1, x);
			} else if (x > numbers[mid]) {
				return search(numbers, mid + 1, end, x);
			}
		}
		return -1;
	}
	
	

}
