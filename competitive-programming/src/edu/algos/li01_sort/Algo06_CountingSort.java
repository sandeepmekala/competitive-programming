package edu.algos.li01_sort;

import java.util.Arrays;

public class Algo06_CountingSort {

	public static void main(String[] args) {			
		Algo06_CountingSort csort = new Algo06_CountingSort();
		int numbers[] = {1,0,3,1,3,1};					
		int[] sortedNumbers = csort.countingSort(numbers);
		System.out.println(Arrays.toString(sortedNumbers));
		
	}
	
	// Idea: Count the frequencies of each element, find the cumulative sum of frequencies to get the correct poitions to put the elements
	// Stable sort
	// Time and space complexity O(n+k)
	private int[] countingSort(int[] numbers){
		int numFreq[] = new int[4];
		int sortedArray[] = new int[numbers.length];
		
		// find frequencies
		for(int i=0; i<numbers.length; i++){
			numFreq[numbers[i]]++;
		}
		
		// cumulative sum of frequencies
		for(int i=1; i<numFreq.length; i++){
			numFreq[i] = numFreq[i] + numFreq[i-1];
		}
		
		// cumulative sum gives from which position the next element should start. 
		// To get from which position the current element should start, we need to shift the indices by one position to right.
		for(int i=numFreq.length-1; i>0; i--){
			numFreq[i] = numFreq[i-1];
		}
		numFreq[0] = 0;
		
		for(int i=0; i<numbers.length; i++){
			int num = numbers[i];
			int index = numFreq[num];
			sortedArray[index] = num;
			
			numFreq[num] = numFreq[num] + 1;
		}
		
		return sortedArray;
	}

}
