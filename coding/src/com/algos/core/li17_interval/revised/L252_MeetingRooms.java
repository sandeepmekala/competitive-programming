package  com.algos.core.li17_interval.revised;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.algos.core.models.Interval;

public class L252_MeetingRooms {

	public static void main(String[] args) {
		L252_MeetingRooms obj = new L252_MeetingRooms();

		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(2,3));
		System.out.println(obj.canAttendMeetings(intervals));
	}

    // Problem: https://www.lintcode.com/problem/920/
    // Check if the intervals overlap.
    // Idea: Sort intervals based on start in asc order.
    // Compare the adjacent intervals and see if they overlap. Track the previous interval in previous variable.
	public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return true;

        Collections.sort(intervals, (i1, i2)->i1.start - i2.start);

        Interval prev = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(prev.end > curr.start)
                return false;

            prev = curr;
        }

        return true;
    }
}
