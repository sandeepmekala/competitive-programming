package edu.algos.sort;

import java.util.Arrays;

public class Algo07_RadixSort {

	public static void main(String[] args) {			
		Algo07_RadixSort rsort = new Algo07_RadixSort();
		int numbers[] = {53, 89, 150, 36, 633, 233};	
		
		int[] sortedNumbers = rsort.radixSort(numbers);
		System.out.println(Arrays.toString(sortedNumbers));
	}
	
	// concept: use counting sort technique. sort the numbers based on integer at each position from right to left
	// stable sort
	// time and space complexity O(d*(n+k))
	private int[] radixSort(int numbers[]){
		
		int position = 1;
		int sortedArray[] = null;
		
		while(position < 1000){
			int freqNumbers[] = new int[10];	//base is 10
			sortedArray = new int[numbers.length];
			
			for(int i=0; i<numbers.length; i++){
				freqNumbers[(numbers[i]/position)%10]++;
			}
			
			for(int i=1; i<freqNumbers.length; i++){
				freqNumbers[i] = freqNumbers[i] + freqNumbers[i-1];
			}
			
			for(int i=freqNumbers.length-1; i>0; i--){
				freqNumbers[i] = freqNumbers[i-1];
			}
			freqNumbers[0] = 0;
			
			for(int i=0; i<numbers.length; i++){
				int num = (numbers[i]/position)%10;
				int index = freqNumbers[num];
				sortedArray[index] = numbers[i];
				
				freqNumbers[num] = freqNumbers[num] + 1;
			}
			position *= 10;
			numbers = sortedArray;
		}
		
		return sortedArray;
	}

}
