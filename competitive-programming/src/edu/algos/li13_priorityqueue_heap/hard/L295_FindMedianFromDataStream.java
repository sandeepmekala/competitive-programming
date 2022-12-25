package edu.algos.li13_priorityqueue_heap.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class L295_FindMedianFromDataStream {

	public static void main(String[] args) {
		L295_FindMedianFromDataStream obj = new L295_FindMedianFromDataStream();
		
		obj.addNum(1);
		obj.addNum(2);
		System.out.println(obj.findMedian());
		obj.addNum(3);
		System.out.println(obj.findMedian());
	}

    // Problem: https://leetcode.com/problems/find-median-from-data-stream/
    // Idea: Use 2 pq's. Store half elements in each q. If odd element, store one extra in q1.
    // q1 should be max queue and q2 should be min queue.
    // You can find the median from top of the q elements.
	PriorityQueue<Integer> minq;
    PriorityQueue<Integer> maxq;
    public L295_FindMedianFromDataStream() {
        minq = new PriorityQueue<>(Collections.reverseOrder());
        maxq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minq.add(num);
        if(minq.size()-maxq.size() > 1){    // move the element to right q if
            maxq.add(minq.remove());
        }

        if(minq.size() > 0 && maxq.size() > 0){     
            while(minq.peek()>maxq.peek()){   //swap the elements to keep both q's elements in order
                maxq.add(minq.remove());
                minq.add(maxq.remove());
            }            
        }
    }
    
    public double findMedian() {
        if(minq.size() == maxq.size()){
            return (minq.peek()+maxq.peek())/2.0;
        }else{
            return minq.peek();
        }
    }
}
