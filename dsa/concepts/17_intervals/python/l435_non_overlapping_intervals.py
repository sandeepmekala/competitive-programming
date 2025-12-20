# Problem: https://leetcode.com/problems/non-overlapping-intervals/
# How many intervals we need to remove to make the intervals non-overlapping.
# Points doesn't overlap
# Idea: It is inverse of Activity Selection Problem.
# n - (number of meetings we can schedule in a room).
# Take the interval which ends first.
# Time: O(n log n)
def erase_overlap_intervals(intervals):
    n = len(intervals)
    if n == 0:
        return 0

    # sort by end time
    intervals.sort(key=lambda x: x[1])

    cnt = 1
    prev_end = intervals[0][1]

    for i in range(1, n):
        if prev_end <= intervals[i][0]:
            cnt += 1
            prev_end = intervals[i][1]

    return n - cnt


# Idea: Sort the interval based on start in asc order.
# Track the previous interval.
# Case 1: Non-overlapping → move prev.
# Case 2: Overlapping → remove one interval.
# Be greedy: keep the interval which ends first.
# Time: O(n log n)
def erase_overlap_intervals2(intervals):
    if not intervals:
        return 0

    intervals.sort(key=lambda x: (x[0], x[1]))

    prev = intervals[0]
    count = 0

    for i in range(1, len(intervals)):
        if intervals[i][0] >= prev[1]:   # non-overlapping
            prev = intervals[i]
        else:                             # overlapping
            count += 1
            if intervals[i][1] < prev[1]:
                prev = intervals[i]      # keep the one ending earlier

    return count


# ------------------ Test (Same as Java main) ------------------

intervals = [[1, 2], [2, 3], [3, 4], [1, 3]]
print(erase_overlap_intervals(intervals.copy()))   # Expected: 1
print(erase_overlap_intervals2(intervals.copy()))  # Expected: 1
