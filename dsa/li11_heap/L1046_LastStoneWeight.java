package li11_heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class L1046_LastStoneWeight {

	public static void main(String[] args) {
		L1046_LastStoneWeight obj = new L1046_LastStoneWeight();
		System.out.println(obj.lastStoneWeight(new int[] {2,7,4,1,8,1}));
	}

	// Problem: https://leetcode.com/problems/last-stone-weight/
	// Smash the stones. Return remaining last stone weight.
	// Idea: Use max heap as we need max elements always
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int num: stones) {
        	maxHeap.add(num);
        }

        while(maxHeap.size() > 1) {
        	int max1 = maxHeap.remove();
        	int max2 = maxHeap.remove();
        	if(max1 != max2) {
        		maxHeap.add(max1-max2);
        	}
        }

        if(maxHeap.size() == 0)
        	return 0;
        return maxHeap.remove();
    }
}
