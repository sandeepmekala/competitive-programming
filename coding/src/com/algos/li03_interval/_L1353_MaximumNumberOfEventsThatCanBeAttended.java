package  com.algos.li03_interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _L1353_MaximumNumberOfEventsThatCanBeAttended {
    public static void main(String[] args) {
        _L1353_MaximumNumberOfEventsThatCanBeAttended obj = new _L1353_MaximumNumberOfEventsThatCanBeAttended();

        int[][] events = new int[][]{{1,2},{2,3},{3,4},{1,2}};
        System.out.println(obj.maxEvents(events));
    }

    // Problem: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort events increasing by start time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans = 0, i = 0, n = events.length;
        for (int d = 1; d <= 100000; d++) {
            while (i < n && events[i][0] == d) { // Add new events that can attend on day `d`
                minHeap.add(events[i++][1]);
            }
            while (!minHeap.isEmpty() && minHeap.peek() < d) { // Remove events that are already closed
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
