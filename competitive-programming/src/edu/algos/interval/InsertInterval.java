package edu.algos.interval;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {

	public static void main(String[] args) {
		InsertInterval obj = new InsertInterval();
		
		int[][] intervals = new int[][] {{1,3},{6,9}};
		int[][] distinctIntervals = obj.insert(intervals, new int[] {2,5});
		for(int i=0; i<distinctIntervals.length; i++) {
			System.out.println(Arrays.toString(distinctIntervals[i]));
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            if(newInterval[1] < intervals[i][0]){
                list.add(newInterval);
                newInterval = intervals[i];
            }else if(newInterval[0] > intervals[i][1]){
                list.add(intervals[i]);
            }else{
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        list.add(newInterval);

        int[][] result = new int[list.size()][2];
        int ind = 0;
        for(int[] interval: list){
            result[ind++] = interval;
        }

        return result;
	}
}
