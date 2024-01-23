package  com.algos.li13_priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L973_KClosestPointsToOrigin {

	public static void main(String[] args) {
		L973_KClosestPointsToOrigin obj = new L973_KClosestPointsToOrigin();
		int[][] points = new int[][] {{6,10},{-3,3},{-2,5},{0,2}};
		int[][] result = obj.kClosest(points, 3);
		for(int[] point: result) {
			System.out.println(Arrays.toString(point));
		}
	}

	// Problem: https://leetcode.com/problems/k-closest-points-to-origin/
	// Idea: Load all the points with sorter as eulidian distance then pop k points from min heap.
    public int[][] kClosest(int[][] points, int k) {
    	int[][] result = new int[k][2];
        PriorityQueue<int[]> minHeap =  new PriorityQueue<int[]>((p1, p2) -> {
        	return (p1[0]*p1[0]+p1[1]*p1[1]) - (p2[0]*p2[0]+p2[1]*p2[1]);
        });
        
        for(int[] point: points) {
        	minHeap.add(point);
        }
        
        int index = 0;
        while(index < k) {
        	result[index++] = minHeap.poll();
        }

        return result;
    }
}
