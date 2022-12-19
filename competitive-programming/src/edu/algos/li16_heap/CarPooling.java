package edu.algos.li16_heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

	public static void main(String[] args) {
		CarPooling obj = new CarPooling();
		
		int[][] trips = new int[][]{{2,1,5},{3,3,7}};
		System.out.println(obj.carPooling(trips, 4));
	}

	/*
	 * Problem: https://leetcode.com/problems/car-pooling/
	 * Companies: Amazon
	 * */
	public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (t1, t2) -> t1[1]-t2[1]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((end1, end2) -> end1[0]-end2[0]);
               
        int currPass = 0;
        for(int[] trip: trips){
            while(!pq.isEmpty() && pq.peek()[0] <= trip[1]) {
                currPass -= pq.remove()[1];
            }
            
            currPass += trip[0];
            pq.add(new int[]{trip[2], trip[0]});
            
            if(currPass > capacity) return false;
            
        }
        
        return true;
    }
}
