package edu.practice.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class OverlappingIntervals {

	public static void main(String[] args) {
		OverlappingIntervals obj = new OverlappingIntervals();
		int[][] intervals = new int[][] {{6,8},{1,9},{2,4},{4,7}};
		int[][] distinctIntervals = obj.overlappedinterval(intervals);
		for(int i=0; i<distinctIntervals.length; i++) {
			System.out.println(Arrays.toString(distinctIntervals[i]));
		}
		
	}

	public int[][] overlappedinterval(int[][] interval)
    {   ArrayList<int[]> res = new ArrayList<int[]>();
        Arrays.sort(interval, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return arr1[0] - arr2[0];
            }
        });
        
        int k=0;
        int n = interval.length;
        int start = interval[0][0];
        int end = interval[0][1];
        //1 3 2 4 6 8 9 10
        //1 9 2 4 4 7 6 8 
        for(int i=1; i<n; i++){
            if(interval[i][0] <= end){
                end = Math.max(end, interval[i][1]);
            }else{
                res.add(new int[]{start, end}); 
                start = interval[i][0];
                end = interval[i][1];
            }
        }
        res.add(new int[]{start, end});
        
        int[][] result = new int[res.size()][2];
        for(int i=0; i<res.size(); i++){
            result[k++] = res.get(i);
        }
        return result;
    }
}
