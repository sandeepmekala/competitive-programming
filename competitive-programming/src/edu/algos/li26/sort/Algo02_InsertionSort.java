package edu.algos.li26.sort;

import java.util.Arrays;

public class Algo02_InsertionSort {

	public static void main(String[] args) {
		Algo02_InsertionSort isort = new Algo02_InsertionSort();
		int[] numbers = {2,7,4,1,5,3};					
		System.out.println(Arrays.toString(numbers));	
		isort.inertionnSort(numbers);							
	}
	
	//concept: treat left array as sorted. Move the current element to its correct position in sorted array by shifting elements to right.
	//time complexity is worst & average case O(n^2). best case O(n)
	//stable sorting
	//space complexity is O(1). Means Inplace sorting.
	private void inertionnSort(int[] numbers) {
		
		for(int i=1; i<numbers.length;i++){
			int current = numbers[i];
			int hole = i;
			while(hole > 0 && numbers[hole-1] > current){
				numbers[hole] = numbers[hole-1];
				hole--;
			}
			numbers[hole] = current;
			System.out.println(Arrays.toString(numbers));
		}
	}
}
