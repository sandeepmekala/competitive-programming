package edu.algos.li13_priorityqueue;

import java.util.PriorityQueue;

public class _L703_KthLargestElementInAStream {

	public static void main(String[] args) {
		_L703_KthLargestElementInAStream kthLargest = new _L703_KthLargestElementInAStream(3, new int[] {4, 5, 8, 2});
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}
	
    // Problem: https://leetcode.com/problems/kth-largest-element-in-a-stream/
    // Idea: Keep k largest elements in min heap so that top of the pq is kth largest.
	int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    public _L703_KthLargestElementInAStream(int k, int[] nums) {
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
