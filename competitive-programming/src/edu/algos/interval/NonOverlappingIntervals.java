package edu.algos.interval;

import java.util.ArrayList;
import java.util.Arrays;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		NonOverlappingIntervals obj = new NonOverlappingIntervals();
		
		System.out.println(obj.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
	}
	
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
                    previous = intervals[i];
                }
            }
        }
        return count;
        
    }

}
