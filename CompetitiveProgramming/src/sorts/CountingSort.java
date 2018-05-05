package sorts;

import java.util.Arrays;
import java.util.Collections;

public class CountingSort {

	public static void main(String[] args) {			//stable sort
		int numbers[] = {1,0,3,1,3,1};					//time and space complexity O(n+k)
		
		int[] sortedNumbers = countingSort(numbers);
		System.out.println(Arrays.toString(sortedNumbers));
		
	}
	private static int[] countingSort(int[] numbers){
		
		int freqNumbers[] = new int[10];
		int sortedArray[] = new int[numbers.length];
		
		for(int i=0; i<numbers.length; i++){
			freqNumbers[numbers[i]]++;
		}
		
		for(int i=1; i<freqNumbers.length; i++){
			freqNumbers[i] = freqNumbers[i] + freqNumbers[i-1];
		}
		
		for(int i=freqNumbers.length-1; i>0; i--){
			freqNumbers[i] = freqNumbers[i-1];
		}
		freqNumbers[0] = 0;
		
		for(int i=0; i<numbers.length; i++){
			int num = numbers[i];
			int index = freqNumbers[num];
			freqNumbers[num] = freqNumbers[num] + 1;
			sortedArray[index] = num;
		}
		
		return sortedArray;
	}

}
