package edu.algos.li08_greedy.medium;

import java.util.ArrayList;
import java.util.Collections;

public class G05_NMeetingsInOneRoom {
    public static void main(String args[]) {
        G05_NMeetingsInOneRoom obj = new G05_NMeetingsInOneRoom();

        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        System.out.println(obj.maxMeetings(start,end,n));
    }

    // Problem: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
    // Idea: You need to sort them on ending. On begenning won't work as one event starting at the begenning might space complete length. Picking that won't allow us to pick more events. Hence, we need to pick events which ends quickly.
    // Activity selection is similar to this problem
    public ArrayList<Integer> maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meet = new ArrayList<>();
        for(int i = 0; i < n; i++)
            meet.add(new Meeting(start[i], end[i], i+1));
        Collections.sort(meet, (m1, m2) -> m1.end-m2.end);

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int lastEnd = meet.get(0).end; 
        
        for(int i = 1;i<n;i++) {
            if(meet.get(i).start > lastEnd) {
                ans.add(meet.get(i).pos);
                lastEnd = meet.get(i).end; 
            }
        }
        
        return ans;
    }
}
class Meeting {
    int start;
    int end;
    int pos;
     
    Meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}