package edu.algos.sort;

import java.util.Arrays;
import java.util.Random;

public class Algo05_QuickSort {

	public static void main(String[] args) {
		Algo05_QuickSort qsort = new Algo05_QuickSort();
		int[] numbers = {7,2,1,6,8,5,3,4};
		qsort.quickSort(numbers,0,7);
	}

	//time complexity in average case O(nlogn). Worst case is O(n^2)
	//non stable sorting
	//space complexity in average case is O(logn) and worst case is O(n^2). So, it is not inplace sorting.
	private void quickSort(int[] numbers, int start, int end) {
		if(start < end){
			System.out.println(Arrays.toString(numbers));
			int pIndex = partition(numbers, start, end);
			quickSort(numbers, start, pIndex-1);
			quickSort(numbers, pIndex+1, end);
		}
	}
	// concept: in recursive quicksort only l,h are sorted in stack. In this approach we use stack to push these pointers. If the returned pivot pointer is > then the l then push l, p-1 and vice versa.
	private void iterativeQuickSort() {
		
	}
	
	// concept: just select a random index and put that element at the start
	private int randomizedPartition(int numbers[], int start, int end){
		Random r = new Random();
		int pIndex = r.nextInt(end-start) + start;
		int temp = numbers[pIndex];
		numbers[pIndex] = numbers[start];
		numbers[start] = temp;
		return partition(numbers, start, end);
	}
	
	private int partition(int numbers[], int start, int end){
		int i = start, j=end;
		while(i<j) {
			while(numbers[i] < numbers[start] && i<j) {		//left element is assumed as pivot
				i++;
			}
			while(numbers[j] > numbers[start] && i<j) {
				j--;
			}
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		int temp = numbers[j];
		numbers[j] = numbers[start];
		numbers[start] = temp;
		return j;
	}

}
