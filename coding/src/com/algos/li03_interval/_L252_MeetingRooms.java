package  com.algos.li03_interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import  com.algos.li30_model.Interval;

public class _L252_MeetingRooms {

	public static void main(String[] args) {
		_L252_MeetingRooms obj = new _L252_MeetingRooms();
		
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(2,3));
		System.out.println(obj.canAttendMeetings(intervals));
	}

    // Problem: https://leetcode.com/problems/meeting-rooms/
    // https://www.lintcode.com/problem/920/
    // Idea: Sort intervals based on start in asc order.
    // Compare the adjacent intervals and see if they overlap. Track the previous interval in previous variable.
	public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return true;
        
        Collections.sort(intervals, (i1, i2)->i1.start - i2.start);

        Interval previous = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval current = intervals.get(i);
            if(current.start < previous.end)
                return false;
            
            previous = current;
        }      
        return true;
    }
}
