package  com.algos.li17_interval.revised;

import java.util.Arrays;

public class L435_NonOverlappingIntervals {

	public static void main(String[] args) {
		L435_NonOverlappingIntervals obj = new L435_NonOverlappingIntervals();
		
		System.out.println(obj.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
	}
	
    // Problem: https://leetcode.com/problems/non-overlapping-intervals/
    // Idea: Sort the interval based on start in asc order.
    // Track the previous interval in previous variable
    // Case 1: Two adjacent intervals are not overlapping. Make the current one as previous.
    // Case 2: Two intervals overlapping. Be greedy, keep the interval which is ending first and delete a interval which in longer so that we avoid more overlappings.
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2)->{
            if(i1[0] == i2[0]){
                return i1[1] - i2[1];
            }
            return i1[0] - i2[0];
        });
        
        int[] prev = intervals[0];
        int count = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0] >= prev[1]){		//non overlapping
                prev = intervals[i];
            }else{									// overlapping
            	count++;
                if(intervals[i][1] < prev[1]){
                    prev = intervals[i];        // be greedy, we will keep the interval which is ending quickly and delete the interval which stretching longer.
                }
            }
        }

        return count;
    }

}
