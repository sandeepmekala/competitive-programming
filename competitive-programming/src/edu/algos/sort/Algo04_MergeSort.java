package edu.algos.sort;

import java.util.Arrays;

public class Algo04_MergeSort {

	public static void main(String[] args) {
		Algo04_MergeSort msort = new Algo04_MergeSort();
		int[] numbers = {2,4,1,6,8,5,3,7};					
		msort.mergeSort(numbers);									
	}
	
	//concept: divide array into two arrays(copied) and call mergeSort recursively for other 2 half then call merge
	//time complexity is worst case O(nlogn)
	//stable sorting
	//space complexity is O(n) if we clear the unused memory during runtime. it will be O(nlogn) if we don't clear the space during runtime. So, it is not inplace sorting.
	private void mergeSort(int[] numbers) {
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
	private void merge(int left[], int right[], int numbers[]){
		int leftInd = 0;
		int rightInd = 0;
		int ind=0;
		
		while(leftInd < left.length && rightInd < right.length){
			if(left[leftInd] <= right[rightInd]){
				numbers[ind++] = left[leftInd++];
			}else{
				numbers[ind++] = right[rightInd++];
			}
		}
		while(leftInd < left.length ){
			numbers[ind++] = left[leftInd++];
		}
		while(rightInd < right.length){
			numbers[ind++] = right[rightInd++];
		}
		System.out.println(Arrays.toString(numbers));
	} 

}
