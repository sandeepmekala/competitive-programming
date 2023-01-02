package edu.algos.li25_sort;

import java.util.Arrays;

public class Algo06_CountingSort {

	public static void main(String[] args) {			
		Algo06_CountingSort csort = new Algo06_CountingSort();
		int numbers[] = {1,0,3,1,3,1};					
		int[] sortedNumbers = csort.countingSort(numbers);
		System.out.println(Arrays.toString(sortedNumbers));
		
	}
	
	// cocept: count the frequencies of each element, find the cumulative sum of frequencies to get the correct poitions to put the elements
	// stable sort
	// time and space complexity O(n+k)
	private int[] countingSort(int[] numbers){
		
		int freqNumbers[] = new int[10];
		int sortedArray[] = new int[numbers.length];
		
		//find frequencies
		for(int i=0; i<numbers.length; i++){
			freqNumbers[numbers[i]]++;
		}
		
		//cumulative sum of frequencies
		for(int i=1; i<freqNumbers.length; i++){
			freqNumbers[i] = freqNumbers[i] + freqNumbers[i-1];
		}
		
		// cumulative sum gives from which position the next element should start. to get from which position the current element should start, we need to shift the indices by one position to right.
		for(int i=freqNumbers.length-1; i>0; i--){
			freqNumbers[i] = freqNumbers[i-1];
		}
		freqNumbers[0] = 0;
		
		for(int i=0; i<numbers.length; i++){
			int num = numbers[i];
			int index = freqNumbers[num];
			sortedArray[index] = num;
			
			freqNumbers[num] = freqNumbers[num] + 1;
		}
		
		return sortedArray;
	}

}
