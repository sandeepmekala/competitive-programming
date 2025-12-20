# Problem: https://leetcode.com/problems/insert-interval/
# Points overlap
# Idea: Add all non overlapping first intervals.
# Merge all overlapping intervals.
# Add all last non overlapping intervals.
def insert(intervals, new_interval):
    n = len(intervals)
    ans = []
    i = 0

    # add all non overlapping intervals before new_interval
    while i < n and intervals[i][1] < new_interval[0]:
        ans.append(intervals[i])
        i += 1

    # merge all overlapping intervals
    # intervals[i][1] > new_interval[0] && intervals[i][0] < new_interval[1]
    while i < n and intervals[i][0] < new_interval[1]:
        new_interval[0] = min(new_interval[0], intervals[i][0])
        new_interval[1] = max(new_interval[1], intervals[i][1])
        i += 1

    ans.append(new_interval)

    # add all remaining non overlapping intervals
    while i < n:
        ans.append(intervals[i])
        i += 1

    return ans


# Idea: Intervals are sorted on start in asc order
# Case 1: Current interval is fully on the left side of start of new interval.
#         Just add this interval to result. new interval will still be new interval.
# Case 2: Current interval is fully on the right side of new interval.
#         Its start is greater than the end of new interval.
#         Insert the new interval into result and make current interval as new interval.
# Case 3: Current interval partially overlaps with new interval.
#         Create a new interval with min and max of these two intervals.
# In all 3 cases, new interval gets propagated till the end of array.
# Add it to the result.
def insert2(intervals, new_interval):
    result = []

    for interval in intervals:
        if interval[1] < new_interval[0]:
            result.append(interval)
        elif interval[0] > new_interval[1]:
            result.append(new_interval)
            new_interval = interval
        else:
            new_interval[0] = min(new_interval[0], interval[0])
            new_interval[1] = max(new_
