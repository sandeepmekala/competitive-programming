package  com.algos.core.li17_interval.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L57_InsertInterval {

	public static void main(String[] args) {
		L57_InsertInterval obj = new L57_InsertInterval();
		
		int[][] intervals = new int[][] {{1,3},{6,9}};
		int[][] ans = obj.insert(intervals, new int[] {3,5});
		for(int i=0; i<ans.length; i++) {
			System.out.println(Arrays.toString(ans[i]));
		}
	}

    // Problem: https://leetcode.com/problems/insert-interval/
    // Points overlap
    // Idea: Add all non overlapping first intervals. 
    // Merge all overlapping intervals. 
    // Add all last non overlapping intervals.
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while(i<n && intervals[i][1] < newInterval[0]){     // add all non over lapping intervals
            ans.add(intervals[i]);
            i++;
        }
        // First is already check above. So, no need to check again.
        // intervals[i][1] > newInterval[0] && intervals[i][0] < newInterval[1]
        while(i<n && intervals[i][0] < newInterval[1]){    // merge all overlapping intervals
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);

        while(i<n){                                     // add all last non over lapping intervals
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
    
    // Idea: Intervals are sorted on start in asc order
    // Case 1: Current interval is fully on the left side of start of new interval. Just add this interval to result. new interal will still be new interval.
    // Case 2: Current interval is fully on the right side of new interval. Its start is greater then the end of new interval. Insert the new interval into result and make current interval as new interval.
    // Case 2: Current interval partially overlaps with new interal. Create a new interval with min and max of these two intervals.
    // In all 3 cases, new interval gets propagated till the end of array. Add it to the result.
	public int[][] insert2(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            if(intervals[i][1] < newInterval[0]){
                list.add(intervals[i]);
            }else if(intervals[i][0] > newInterval[1]){
                list.add(newInterval);
                newInterval = intervals[i];
            }else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        list.add(newInterval);

        return list.toArray(new int[list.size()][2]);
	}
}
