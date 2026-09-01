# Problem: https://leetcode.com/problems/merge-intervals/
# Points overlap
# Idea: Sort intervals based on start in asc order. Compare adjacent intervals.
# Track the previous interval.
# There are 2 cases to handle
# Case 1: No overlapping. Add the previous interval to result and assign the current interval to previous.
# Case 2: Overlapping: Create a new previous interval with 2 intervals min and max.
# In both the cases, previous will be propogating till the end. Add it to the result at the end.
def merge(intervals):
    # sort intervals by start time
    intervals.sort(key=lambda x: x[0])

    ans = []
    merged = intervals[0]

    for i in range(1, len(intervals)):
        if merged[1] >= intervals[i][0]:
            merged[1] = max(merged[1], intervals[i][1])
        else:
            ans.append(merged)
            merged = intervals[i]

    ans.append(merged)
    return ans


# ------------------ Test (Same as Java main) ------------------

intervals = [[6, 8], [2, 4], [4, 7]]
distinct_intervals = merge(intervals)
for interval in distinct_intervals:
    print(interval)
