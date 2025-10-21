package  com.algos.topics.li17_interval.revised;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L1353_MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        L1353_MaximumNumberOfEventsThatCanBeAttended obj = new L1353_MaximumNumberOfEventsThatCanBeAttended();

        int[][] events = new int[][]{{1,2},{2,3},{3,4},{1,2}};
        System.out.println(obj.maxEvents(events));
    }

    // Problem: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort events increasing by start time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((e1, e2) -> e1[1]- e2[1]);
        int ans = 0, i = 0, n = events.length;
        for (int d = 1; d <= 100000; d++) {
            while (i < n && events[i][0] == d) { // Add new events that can attend on day `d`
                minHeap.add(events[i++]);
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] < d) { // Remove events that are already closed
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) { // Use day `d` to attend to the event that closes earlier
                ans++;
                minHeap.poll();
            }
        }
        return ans;
    }
}
