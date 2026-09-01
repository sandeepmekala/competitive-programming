# Problem: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
# Idea:
# - Sort events by start day.
# - Use a min-heap ordered by end day.
# - For each day:
#   1. Add all events starting on that day to the heap.
#   2. Remove events that already ended.
#   3. Attend the event that ends the earliest.
# Time: O(n log n), Space: O(n)

import heapq

def max_events(events):
    # sort events by start day
    events.sort(key=lambda x: x[0])

    min_heap = []  # min-heap by end day
    ans = 0
    i = 0
    n = len(events)

    # As per constraints, days go up to 100000
    for day in range(1, 100001):
        # add all events starting today
        while i < n and events[i][0] == day:
            # push (end_day, start_day) or just (end_day)
            heapq.heappush(min_heap, events[i])
            i += 1

        # remove events that already ended
        while min_heap and min_heap[0][1] < day:
            heapq.heappop(min_heap)

        # attend the event that ends earliest
        if min_heap:
            ans += 1
            heapq.heappop(min_heap)

    return ans


# ------------------ Test (Same as Java main) ------------------

events = [[1, 2], [2, 3], [3, 4], [1, 2]]
print(max_events(events))  # Expected: 4
