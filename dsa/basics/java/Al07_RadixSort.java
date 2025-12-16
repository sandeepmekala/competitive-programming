package basics.java;

import java.util.Arrays;

public class Al07_RadixSort {

	public static void main(String[] args) {
		Al07_RadixSort rsort = new Al07_RadixSort();
		int numbers[] = {53, 89, 150, 36, 633, 233};

		int[] sortedNumbers = rsort.radixSort(numbers);
		System.out.println(Arrays.toString(sortedNumbers));
	}

	// Idea: Use counting sort technique. Sort the numbers based on integer at each position from right to left
	// Stable sort
	// Time and space complexity O(d*(n+k))
	public int[] radixSort(int nums[]){
		int pos = 1, n = nums.length;
		int sortedArray[] = null;

		while(pos < 1000){
			int numFreqs[] = new int[10];	//base is 10
			sortedArray = new int[n];

			for(int i=0; i<n; i++){
				numFreqs[(nums[i]/pos)%10]++;
			}

			for(int i=1; i<numFreqs.length; i++){
				numFreqs[i] = numFreqs[i] + numFreqs[i-1];
			}

			for(int i=numFreqs.length-1; i>0; i--){
				numFreqs[i] = numFreqs[i-1];
			}
			numFreqs[0] = 0;

			for(int i=0; i<n; i++){
				int num = (nums[i]/pos)%10;
				int index = numFreqs[num];

				sortedArray[index] = nums[i];
				numFreqs[num] = numFreqs[num] + 1;
			}
			pos *= 10;
			nums = sortedArray;
		}

		return sortedArray;
	}

}
