# Problem: https://leetcode.com/problems/minimum-interval-to-include-each-query/
# Idea:
# Sort intervals and queries.
# Use a min-heap to store candidate intervals for each query.
# 1. Add all intervals whose start <= query time into the heap.
# 2. Remove intervals whose end < query time (inconsistent intervals).
# 3. The heap top gives the minimum-size valid interval.
# Time: O(n log n + q log q)

import heapq

def min_interval(intervals, queries):
    n = len(intervals)
    q = len(queries)

    # sort intervals by start time
    intervals.sort(key=lambda x: x[0])

    # keep original index of queries
    sorted_queries = [(queries[i], i) for i in range(q)]
    sorted_queries.sort(key=lambda x: x[0])

    # min-heap: (interval_size, end, start)
    heap = []

    ans = [-1] * q
    i = 0

    for query_time, query_index in sorted_queries:
        # add all intervals that can start before or at query_time
        while i < n and intervals[i][0] <= query_time:
            start, end = intervals[i]
            size = end - start + 1
            heapq.heappush(heap, (size, end, start))
            i += 1

        # remove intervals that do not cover query_time
        while heap and heap[0][1] < query_time:
            heapq.heappop(heap)

        # top of heap is the smallest valid interval
        if heap:
            ans[query_index] = heap[0][0]
        else:
            ans[query_index] = -1

    return ans


# ------------------ Test (Same as Java main) ------------------

intervals = [[1, 4], [2, 4], [3, 6], [4, 4]]
queries = [2, 3, 4, 5]
print(min_interval(intervals, queries))
# Expected: [3, 3, 1, 4]
