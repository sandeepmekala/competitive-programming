# Problem: https://www.lintcode.com/problem/919
# Minimum number of meeting rooms required
# Idea: Minimum Number Of Platforms Required
# We need to find the maximum parallel interviews that can happen to find the min rooms.
# Store all start and end points to a separate lists and sort them in asc order.
# Start picking the minimum from two lists. If it is start, increase count, which means
# we need one more additional room for the new meeting. Once you increase count, update
# and track global max.
# If it is end of some meeting, decrease count as some meeting ended which will free up some room.
# Time: O(nlogn)
def min_meeting_rooms(intervals):
    n = len(intervals)
    if n <= 1:
        return n

    starts = []
    ends = []

    for start, end in intervals:
        starts.append(start)
        ends.append(end)

    starts.sort()
    ends.sort()

    cnt = 0
    max_rooms = 0
    i = 0
    j = 0

    # As arrivals will end first
    while i < n:
        if starts[i] < ends[j]:
            cnt += 1
            i += 1
            max_rooms = max(max_rooms, cnt)
        else:
            cnt -= 1
            j += 1

    return max_rooms


# ------------------ Test (Equivalent to Java main) ------------------

intervals = [(0, 30), (5, 10), (15, 20)]
print(min_meeting_rooms(intervals))  # Expected: 2
