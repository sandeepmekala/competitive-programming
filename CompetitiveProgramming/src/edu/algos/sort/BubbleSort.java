package edu.algos.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] numbers = {2,7,4,1,5,3};					
		System.out.println(Arrays.toString(numbers));
		bubbleSort(numbers);							
														
	}

	//concept: biggest elements is bubbled to last one for each iteration
	//time complexity is worst & average case O(n^2). Best case O(n)
	//stable sorting
	//space complexity is O(1). Means Inplace sorting.
	private static void bubbleSort(int[] numbers) {
		for(int i=0; i<numbers.length; i++){
			boolean sorted = true;
			for(int j=0; j<numbers.length-1; j++){
				if(numbers[j] > numbers[j+1]){
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] =temp;
					
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
