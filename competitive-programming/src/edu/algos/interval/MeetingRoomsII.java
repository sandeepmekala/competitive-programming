package edu.algos.interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.algos.model.Interval;

public class MeetingRoomsII {

	public static void main(String[] args) {
		MeetingRoomsII obj = new MeetingRoomsII();
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(0,30));
		intervals.add(new Interval(5,10));
		intervals.add(new Interval(15,20));
		System.out.println(obj.minMeetingRooms(intervals));
	}

	public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int n = intervals.size();
        if(n <= 1){
            return n;
        }
        ArrayList<Integer> start = new ArrayList<Integer>();
        ArrayList<Integer> end = new ArrayList<Integer>();
        for(Interval interval: intervals){
            start.add(interval.start);
            end.add(interval.end);
        }
        Collections.sort(start);
        Collections.sort(end);

        int count = 0, max = 0, i=0, j=0;
        while(i<n){
            if(start.get(i) < end.get(j)){
                count++;
                max = Math.max(max, count);
                i++;
            }else{
                count--;
                j++;
            }
        }
        return max;
    }
}
