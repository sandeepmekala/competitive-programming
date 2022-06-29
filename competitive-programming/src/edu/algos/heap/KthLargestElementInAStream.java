package edu.algos.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAStream {

	public static void main(String[] args) {
		KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, new int[] {4, 5, 8, 2});
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}
	
	int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
        	minHeap.add(num);
        }
        while(minHeap.size() > k) {
        	minHeap.poll();
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.add(val);
        }else if(val > minHeap.peek()) {
        	minHeap.add(val);
        	minHeap.poll();
        }
        
    	if(minHeap.size() < k){
            return -1;
        }
        return minHeap.peek();
    }
}
