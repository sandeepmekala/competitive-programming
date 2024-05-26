package  com.algos.core.li11_heap.revised;

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
	PriorityQueue<Integer> maxq;
    PriorityQueue<Integer> minq;
    public L295_FindMedianFromDataStream() {
        maxq = new PriorityQueue<>(Collections.reverseOrder());  //q1
        minq = new PriorityQueue<>();  // q2
    }
    
    public void addNum(int num) {
        maxq.add(num);
        if(maxq.size()-minq.size() > 1)    // move the element to right q if
            minq.add(maxq.remove());

        if(maxq.size() > 0 && minq.size() > 0){     
            if(maxq.peek()>minq.peek()){   //swap the elements to keep both q's elements in sync
                minq.add(maxq.remove());
                maxq.add(minq.remove());
            }            
        }
    }
    
    public double findMedian() {
        if(maxq.size() == minq.size()){
            return (maxq.peek()+minq.peek())/2.0;
        }else{
            return maxq.peek();
        }
    }
}
