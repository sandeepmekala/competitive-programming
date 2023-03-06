package edu.algos.li08_greedy;

import java.util.Arrays;

public class L1353_MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        L1353_MaximumNumberOfEventsThatCanBeAttended obj = new L1353_MaximumNumberOfEventsThatCanBeAttended();

        int[][] events = new int[][]{{1,2},{2,3},{3,4},{1,2}};
        System.out.println(obj.maxEvents(events));
    }

    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (e1, e2) -> e1[1]-e2[1]);

        int ans = 1;
        int lastEnd = events[0][1]; 
        
        for(int i = 1;i<n;i++) {
            if(events[i][0] >= lastEnd) {
                ans++;
                lastEnd = events[i][1]; 
            }
        }
        
        return ans;
    }
}
