# Problem: https://www.lintcode.com/problem/920/
# Check if the intervals overlap.
# Idea: Sort intervals based on start in asc order.
# Compare the adjacent intervals and see if they overlap.
# Track the previous interval in previous variable.
def can_attend_meetings(intervals):
    if len(intervals) <= 1:
        return True

    # sort by start time
    intervals.sort(key=lambda x: x[0])

    prev_start, prev_end = intervals[0]
    for i in range(1, len(intervals)):
        curr_start, curr_end = intervals[i]
        if prev_end > curr_start:
            return False
        prev_start, prev_end = curr_start, curr_end

    return True


# ------------------ Test (Equivalent to Java main) ------------------

intervals = [(1, 2), (2, 3)]
print(can_attend_meetings(intervals))  # Expected: True
