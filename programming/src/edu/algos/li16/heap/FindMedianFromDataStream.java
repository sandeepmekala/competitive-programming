package edu.algos.li16.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	public static void main(String[] args) {
		FindMedianFromDataStream obj = new FindMedianFromDataStream();
		
		obj.addNum(1);
		obj.addNum(2);
		System.out.println(obj.findMedian());
		obj.addNum(3);
		System.out.println(obj.findMedian());
	}

	PriorityQueue<Integer> minq;
    PriorityQueue<Integer> maxq;
    public FindMedianFromDataStream() {
        minq = new PriorityQueue<>(Collections.reverseOrder());
        maxq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minq.add(num);
        int diff = minq.size()-maxq.size();

        while(diff > 1){
            maxq.add(minq.remove());
            break;
        }
        while(diff < -1){
            minq.add(maxq.remove());
            break;
        }
        if(minq.size() > 0 && maxq.size() > 0){
            while(minq.peek()>maxq.peek()){
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
