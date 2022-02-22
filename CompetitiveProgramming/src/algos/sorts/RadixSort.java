package algos.sorts;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {			//stable sort
		int numbers[] = {53, 89, 150, 36, 633, 233};	//time and space complexity O(d*(n+k))
		
		int[] sortedNumbers = radixSort(numbers);
		System.out.println(Arrays.toString(sortedNumbers));
	}
	
	private static int[] radixSort(int numbers[]){
		
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
				freqNumbers[num] = freqNumbers[num] + 1;
				sortedArray[index] = numbers[i];
			}
			position *= 10;
			numbers = sortedArray;
		}
		
		return sortedArray;
	}

}
