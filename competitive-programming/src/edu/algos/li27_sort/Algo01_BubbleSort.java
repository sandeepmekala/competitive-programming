package edu.algos.li27_sort;

import java.util.Arrays;

public class Algo01_BubbleSort {

	public static void main(String[] args) {
		Algo01_BubbleSort bsort = new Algo01_BubbleSort();
		int[] numbers = {2,7,4,1,5,3};					
		System.out.println(Arrays.toString(numbers));
		bsort.bubbleSort(numbers);							
														
	}

	// Idea: biggest element is bubbled to last one for each iteration
	// time complexity in worst & average case is O(n^2). Best case O(n)
	// stable sorting
	// space complexity is O(1). Means Inplace sorting.
	private void bubbleSort(int[] numbers) {
		for(int i=0; i<numbers.length; i++){
			boolean sorted = true;
			for(int j=0; j<numbers.length-1; j++){
				if(numbers[j] > numbers[j+1]){
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					
					sorted = false;
				}
			}
			if(sorted){
				break;
			}
			System.out.println(Arrays.toString(numbers));
		}
		
	}

}
