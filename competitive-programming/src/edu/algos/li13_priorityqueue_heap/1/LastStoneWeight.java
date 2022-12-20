package edu.algos.li13_priorityqueue_heap.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		LastStoneWeight obj = new LastStoneWeight();
		System.out.println(obj.lastStoneWeight(new int[] {2,7,4,1,8,1}));
	}

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num: stones) {
        	maxHeap.add(num);
        }
        maxHeap.remove();
        
        while(maxHeap.size() > 1) {
        	int max1 = maxHeap.poll();
        	int max2 = maxHeap.poll();
        	if(max1 != max2) {
        		int diff = Math.abs(max2-max1);
        		maxHeap.add(diff);
        	}
        }
        
        if(maxHeap.size() == 0) {
        	return 0;
        }
        return maxHeap.poll();
    }
}
