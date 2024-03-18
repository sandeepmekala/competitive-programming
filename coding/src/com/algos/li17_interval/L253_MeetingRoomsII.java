package  com.algos.li17_interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import  com.algos.li30_model.Interval;

public class L253_MeetingRoomsII {

	public static void main(String[] args) {
		L253_MeetingRoomsII obj = new L253_MeetingRoomsII();
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(0,30));
		intervals.add(new Interval(5,10));
		intervals.add(new Interval(15,20));
		System.out.println(obj.minMeetingRooms(intervals));
	}

    // Problem: https://leetcode.com/problems/meeting-rooms-ii/
    // https://www.lintcode.com/problem/919
    // Idea: We need to find the maximum parallel interviews that can happen to find the min rooms.
    // Store all start and end points to a separate lists and sort them in asc order.
    // Start picking the minimum from two lists. If it is start, increase count which means we need one more additional room for the new meeting. Once you increase count, update and trakc global max.
    // If it is end of some meeting, decrease count as some meeting ended which will free up some room.
	public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return intervals.size();
        
        ArrayList<Integer> starts = new ArrayList<Integer>();
        ArrayList<Integer> ends = new ArrayList<Integer>();
        for(Interval interval: intervals){
            starts.add(interval.start);
            ends.add(interval.end);
        }
        Collections.sort(starts);
        Collections.sort(ends);

        int count = 0, max = 0;
        int i=0, j=0;
        while(i<intervals.size()){
            if(starts.get(i) < ends.get(j)){
                count++;
                i++;
                max = Math.max(max, count);
            }else{
                count--;
                j++;
            }
        }
        return max;
    }
}
