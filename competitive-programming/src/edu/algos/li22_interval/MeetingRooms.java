package edu.algos.li22_interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.algos.li00_model.Interval;

public class MeetingRooms {

	public static void main(String[] args) {
		MeetingRooms obj = new MeetingRooms();
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(2,3));
		System.out.println(obj.canAttendMeetings(intervals));
	}

	public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if(intervals.size() <= 1){
            return true;
        }
        Collections.sort(intervals, (i1, i2)->{
            return i1.start - i2.start;
        });

        Interval previous = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start < previous.end){
                return false;
            }
        }      
        return true;
    }
}
