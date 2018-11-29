package sorts;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int[] numbers = {7,2,1,6,8,5,3,4};					//time complexity is worst & average case O(nlogn). Worst case is O(n^2)
		System.out.println(Arrays.toString(numbers));	
		quickSort(numbers,0,7);								//Non stable sorting
															//space complexity is average case is O(logn) and worst case id O(n^2). So, it is inplace sorting.
		System.out.println(Arrays.toString(numbers));
	}

	private static void quickSort(int[] numbers, int start, int end) {
		if(start < end){
			int pIndex = randomizedPartition(numbers, start, end);
			quickSort(numbers, start, pIndex-1);
			quickSort(numbers, pIndex+1, end);
		}
	}
	private static int randomizedPartition(int numbers[], int start, int end){
		Random r = new Random();
		int pIndex = r.nextInt(end-start) + start;
		int temp = numbers[pIndex];
		numbers[pIndex] = numbers[end];
		numbers[end] = temp;
		return partition(numbers, start, end);
	}
	private static int partition(int numbers[], int start, int end){
		int pIndex = start;
		for(int i=start; i<end; i++){
			if(numbers[i] <= numbers[end]){
				int temp = numbers[pIndex];
				numbers[pIndex] = numbers[i];
				numbers[i] = temp;
				
				pIndex ++;
			}
		}
		int temp = numbers[pIndex];
		numbers[pIndex] = numbers[end];
		numbers[end] = temp;
		return pIndex;
	}

}
