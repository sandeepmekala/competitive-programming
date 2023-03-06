package edu.algos.li13_priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class L1046_LastStoneWeight {

	public static void main(String[] args) {
		L1046_LastStoneWeight obj = new L1046_LastStoneWeight();
		System.out.println(obj.lastStoneWeight(new int[] {2,7,4,1,8,1}));
	}

	// Problem: https://leetcode.com/problems/last-stone-weight/
	// Idea: Use max heap as we need max elements always
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num: stones) {
        	maxHeap.add(num);
        }
        
        while(maxHeap.size() > 1) {
        	int max1 = maxHeap.poll();
        	int max2 = maxHeap.poll();
        	if(max1 != max2) {
        		maxHeap.add(max1-max2);
        	}
        }
        
        if(maxHeap.size() == 0) {
        	return 0;
        }
        return maxHeap.poll();
    }
}
