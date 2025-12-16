
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.algos.topics.models.Interval;

public class L253_MeetingRoomsII {

	public static void main(String[] args) {
		L253_MeetingRoomsII obj = new L253_MeetingRoomsII();

		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(0,30));
		intervals.add(new Interval(5,10));
		intervals.add(new Interval(15,20));
		System.out.println(obj.minMeetingRooms(intervals));
	}

    // Problem: https://www.lintcode.com/problem/919
    // Minimum number of meeting rooms required
    // Idea: Minimum Number Of Platforms Required
    // We need to find the maximum parallel interviews that can happen to find the min rooms.
    // Store all start and end points to a separate lists and sort them in asc order.
    // Start picking the minimum from two lists. If it is start, increase count, which means we need one more additional room for the new meeting. Once you increase count, update and track global max.
    // If it is end of some meeting, decrease count as some meeting ended which will free up some room.
	// Time: O(nlogn)
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if(n <= 1)
            return n;

        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for(Interval interval: intervals){
            starts.add(interval.start);
            ends.add(interval.end);
        }
        Collections.sort(starts);
        Collections.sort(ends);

        int cnt = 0, max = 0;
        int i=0, j=0;
        while(i<n){          // As arrivals will end first
            if(starts.get(i) < ends.get(j)){
                cnt++;
                i++;
                max = Math.max(max, cnt);
            }else{
                cnt--;
                j++;
            }
        }
        return max;
    }
}
