package edu.algos.li22_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

	public static void main(String[] args) {
		MergeIntervals obj = new MergeIntervals();
		
		int[][] intervals = new int[][] {{6,8},{1,9},{2,4},{4,7}};
		int[][] distinctIntervals = obj.merge(intervals);
		for(int i=0; i<distinctIntervals.length; i++) {
			System.out.println(Arrays.toString(distinctIntervals[i]));
		}
		
	}

	public int[][] merge(int[][] interval){
        Arrays.sort(interval, (arr1, arr2)->{
                return arr1[0] - arr2[0];
            });
        
        int[] previous = interval[0];
        ArrayList<int[]> list = new ArrayList<int[]>();
        
        for(int i=1; i<interval.length; i++){
            if(interval[i][0] <= previous[1]){
            	previous[0] = Math.min(previous[0], interval[i][0]);
            	previous[1] = Math.max(previous[1], interval[i][1]);
            }else{
                list.add(previous); 
                previous = interval[i];
            }
        }
        list.add(previous);
        
        int[][] result = new int[list.size()][2];
        int ind=0;
        for(int i=0; i<list.size(); i++){
            result[ind++] = list.get(i);
        }
        return result;
    }
}
