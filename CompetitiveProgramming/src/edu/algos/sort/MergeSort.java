package edu.algos.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] numbers = {2,4,1,6,8,5,3,7};					
		mergeSort(numbers);									
	}
	
	//concept: divide array into two arrays(copied) and call mergeSort recursively for other 2 half then call merge
	//time complexity is worst case O(nlogn)
	//stable sorting
	//space complexity is O(n) if we clear the unused memory during runtime. it will be O(nlogn) if we don't clear the space during runtime. So, it is not inplace sorting.
	private static void mergeSort(int[] numbers) {
		System.out.println(Arrays.toString(numbers));
		if(numbers.length < 2){
			return;
		}
		int mid = numbers.length/2;
		int left[] = new int[mid];
		int right[] = new int[numbers.length-mid];
		
		for(int i=0; i<mid; i++){
			left[i] = numbers[i];
		}
		for(int i=mid; i<numbers.length; i++){
			right[i-mid] = numbers[i];
		}
		mergeSort(left);
		mergeSort(right);
		merge(left, right, numbers);
	}
	private static void merge(int left[], int right[], int numbers[]){
		int nLeft = 0;
		int nRight = 0;
		int k=0;
		
		while(nLeft < left.length && nRight < right.length){
			if(left[nLeft] <= right[nRight]){
				numbers[k++] = left[nLeft++];
			}else{
				numbers[k++] = right[nRight++];
			}
		}
		while(nLeft < left.length ){
			numbers[k++] = left[nLeft++];
		}
		while(nRight < right.length){
			numbers[k++] = right[nRight++];
		}
		System.out.println(Arrays.toString(numbers));
	} 

}
