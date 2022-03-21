package edu.ds.arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SortNearlySortedOrKSortedArray {

	//O(k)+(n)log(k)
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 6, 3, 12, 56, 8 };
		int k=4;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		//takes O(k)
		for(int i=0; i<k+1; i++) {
			minHeap.add(arr[i]);
		}
		
		//takes (n-k)log(k)
		int index = 0;
		for(int i=k+1; i<arr.length; i++) {
			arr[index++] = minHeap.poll();
			minHeap.add(arr[i]);
		}
		
		//takes (k)log(k)
		for(int i=0; i<k+1; i++) {
			arr[index++] = minHeap.poll();
		}
		System.out.println(Arrays.toString(arr));
	}

}