package edu.algos.li13_priorityqueue_heap.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L1094_CarPooling {

	public static void main(String[] args) {
		L1094_CarPooling obj = new L1094_CarPooling();
		
		int[][] trips = new int[][]{{2,1,5},{3,3,7}};
		System.out.println(obj.carPooling(trips, 4));
	}

	/*
	 * Problem: https://leetcode.com/problems/car-pooling/
	 * Companies: Amazon
     * Idea: We have process the trips in start order. Hence sort them on start.
     * All the trips that we are picking, we need to find first ending trip to remove it from car. Hence, load picked trips to pq based on ending.
     * Sorting on end will not work as we don't know which trips will pick up.
     * 
	 * */
	public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1_start, t2_start) -> t1_start[1]-t2_start[1]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((t1_end, t2_end) -> t1_end[2]-t2_end[2]);
        int currPass = 0;
        for(int[] trip: trips){
            while(!pq.isEmpty() && pq.peek()[2] <= trip[1]) {
                currPass -= pq.remove()[0];
            }
            
            currPass += trip[0];
            pq.add(trip);
            
            if(currPass > capacity) return false;
        }
        
        return true;
    }
}
