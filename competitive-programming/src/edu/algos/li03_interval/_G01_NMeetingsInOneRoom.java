package edu.algos.li03_interval;

import java.util.ArrayList;
import java.util.Collections;

import edu.algos.li30_model.Interval;

public class _G01_NMeetingsInOneRoom {
    public static void main(String args[]) {
        _G01_NMeetingsInOneRoom obj = new _G01_NMeetingsInOneRoom();

        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        System.out.println(obj.maxMeetings(start,end,n));
    }

    // Problem: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
    // Idea: You need to sort them on ending. On begenning won't work as one event starting at the begenning might space complete length. Picking that won't allow us to pick more events. Hence, we need to pick events which ends quickly to maximize.
    // Activity selection is similar to this problem
    public ArrayList<Integer> maxMeetings(int start[], int end[], int n) {
        ArrayList<Interval> intervals = new ArrayList<>();
        for(int i = 0; i < n; i++)
            intervals.add(new Interval(start[i], end[i], i+1));

        Collections.sort(intervals, (m1, m2) -> m1.end-m2.end);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(intervals.get(0).pos);
        
        int lastEnd = intervals.get(0).end; 
        for(int i = 1;i<n;i++) {
            if(intervals.get(i).start > lastEnd) {
                ans.add(intervals.get(i).pos);
                lastEnd = intervals.get(i).end; 
            }
        }
        
        return ans;
    }
}