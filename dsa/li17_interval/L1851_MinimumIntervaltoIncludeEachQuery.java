
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class L1851_MinimumIntervaltoIncludeEachQuery {

    public static void main(String[] args) {
        L1851_MinimumIntervaltoIncludeEachQuery obj = new L1851_MinimumIntervaltoIncludeEachQuery();

        int[][] intervals = { { 1, 4 }, { 2, 4 }, { 3, 6 }, { 4, 4 } };
        int[] queries = { 2, 3, 4, 5 };
        System.out.println(Arrays.toString(obj.minInterval(intervals, queries)));
    }

    // Problem: https://leetcode.com/problems/minimum-interval-to-include-each-query/
    // Idea: Sort intervals and queries.
    // Use pq to store and get min size interval for every query.
    // 1. Keep taking all those queries which have lower starting time than the query time and add them to priority queue
    // 2. Keep removing the inconsistent intervals and get the min size interval from priority queue
    // 3. Now, priority queue must have the consistent & smallest interval. Take it into ans.
    // Time: O(nlogn + qlogq)
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length, q = queries.length;

        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));

        Query[] sortedQueries = new Query[q];
        for (int i = 0; i < q; i++)
            sortedQueries[i] = new Query(i, queries[i]);
        Arrays.sort(sortedQueries, (q1, q2) -> (q1.time - q2.time));

        // algorithm
        Queue<int[]> pq = new PriorityQueue<>((i1, i2) -> {
            int size1 = (i1[1] - i1[0] + 1), size2 = (i2[1] - i2[0] + 1);
            if (size1 != size2)
                return (size1 - size2);
            return (i1[1] - i2[1]);
        });

        int i = 0;
        for (Query query : sortedQueries) {
            while (i < n && intervals[i][0] <= query.time)
                pq.add(intervals[i++]);

            while (!pq.isEmpty() && (pq.peek()[1] < query.time))
                pq.remove();

            int ans = pq.isEmpty() ? -1 : (pq.peek()[1] - pq.peek()[0] + 1);
            query.setAns(ans);
        }

        // reconversion
        int[] ans = new int[q];
        for (Query query : sortedQueries)
            ans[query.index] = query.ans;
        return ans;
    }
}

class Query {

    int index;
    int time;
    int ans;

    public Query(int index, int time) {
        this.index = index;
        this.time = time;
        this.ans = -1; // initially store as -1
    }

    public void setAns(int result) {
        this.ans = result;
    }
}
