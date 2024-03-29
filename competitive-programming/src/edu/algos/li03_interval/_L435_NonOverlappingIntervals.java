package edu.algos.li03_interval;

import java.util.Arrays;

public class _L435_NonOverlappingIntervals {

	public static void main(String[] args) {
		_L435_NonOverlappingIntervals obj = new _L435_NonOverlappingIntervals();
		
		System.out.println(obj.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
	}
	
    // Problem: https://leetcode.com/problems/non-overlapping-intervals/
    // Idea: Sort the interval based on start in asc order.
    // Track the previous interval in previous variable
    // Case 1: Two adjacent intervals are not overlapping. Make the current one as previous.
    // Case 2: Two intervals overlapping. Be greedy, keep the interval which is ending first and delete a interval which in longer so that we avoid more overlappings.
	// TODO
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2)->{
            if(i1[0] == i2[0]){
                return i1[1] - i2[1];
            }
            return i1[0] - i2[0];
        });
        
        int[] previous = intervals[0];
        int count = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= previous[1]){		//non overlapping
                previous = intervals[i];
            }else{									// overlapping
            	count++;
                if(intervals[i][1] < previous[1]){
                    previous = intervals[i];        // be greedy, we will keep the interval which is ending quickly and delete the interval which stretching longer.
                }
            }
        }

        return count;
    }

}
