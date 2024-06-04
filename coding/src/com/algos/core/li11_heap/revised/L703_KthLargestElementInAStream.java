package  com.algos.core.li11_heap.revised;

import java.util.PriorityQueue;
import java.util.Queue;

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
    Queue<Integer> minHeap = new PriorityQueue<>();
    public L703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        for(int num: nums) {
        	minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.remove();
            }
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
