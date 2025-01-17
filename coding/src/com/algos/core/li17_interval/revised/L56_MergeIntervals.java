package  com.algos.core.li17_interval.revised;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56_MergeIntervals {

	public static void main(String[] args) {
		L56_MergeIntervals obj = new L56_MergeIntervals();
		
		int[][] intervals = new int[][] {{6,8},{2,4},{4,7}};
		int[][] distinctIntervals = obj.merge(intervals);
		for(int i=0; i<distinctIntervals.length; i++) {
			System.out.println(Arrays.toString(distinctIntervals[i]));
		}
		
	}

    // Problem: https://leetcode.com/problems/merge-intervals/
    // Points overlap
    // Idea: Sort intervals based on start in asc order. Compare adjacent intervals. Track the previous interval.
    // There are 2 cases to handle
    // Case 1: No overlapping. Add the previous interval to result and assign the current interval to previous.
    // Case 2: Overlapping: Create a new previous interval with 2 intervals min and max.
    // In both the cases, previous will be propogating till the end. Add it to the result at the end.
	public int[][] merge(int[][] interval){
        Arrays.sort(interval, (i1, i2) -> i1[0] - i2[0]);
        
        List<int[]> ans = new ArrayList<>();
        int[] merged = interval[0];
        for(int i=1; i<interval.length; i++){
            if(merged[1] >= interval[i][0]){
            	merged[1] = Math.max(merged[1], interval[i][1]);
            }else{
                ans.add(merged); 
                merged = interval[i];
            }
        }
        ans.add(merged);

        return ans.toArray(new int[ans.size()][2]);
    }
}
