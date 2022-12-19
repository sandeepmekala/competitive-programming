package edu.algos.li27_sort;

import java.util.Arrays;

public class Algo03_SelectionSort {

	public static void main(String[] args) {
		Algo03_SelectionSort ssort = new Algo03_SelectionSort();
		int[] numbers = {2,7,4,1,5,3};					
		System.out.println(Arrays.toString(numbers));
		ssort.selectionSort(numbers);							
	}

	// Idea: select min element in each iteration and put it in its correct place
	// time complexity is O(n^2)
	// non-stable sorting
	// space complexity is O(1). Means Inplace sorting.
	private void selectionSort(int[] numbers) {
		for(int i=0; i<numbers.length-1; i++){
			int imin = i;
			for(int j=i+1; j<numbers.length; j++){
				if(numbers[j] < numbers[imin]){
					imin = j;
				}
			}
			int temp = numbers[imin];
			numbers[imin] = numbers[i];
			numbers[i] = temp;
			System.out.println(Arrays.toString(numbers));
		}		
	}

}
