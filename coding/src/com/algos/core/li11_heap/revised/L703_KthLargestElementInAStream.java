package  com.algos.core.li11_heap.revised;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L703_KthLargestElementInAStream {

	public static void main(String[] args) {
		L703_KthLargestElementInAStream kthLargest = new L703_KthLargestElementInAStream(3, new int[] {4, 5, 8, 2});
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
    public L703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
        	minHeap.add(num);
        }

        while(minHeap.size() > k) {
        	minHeap.remove();
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if(minHeap.size() > k)
        	minHeap.remove();
        
    	if(minHeap.size() < k)
            return -1;

        return minHeap.peek();
    }
}
