# Problem: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
# Idea:
# Sort meetings based on end time.
# Picking the meeting that ends earliest leaves maximum room for remaining meetings.
# This is the classic Activity Selection Problem.
# Time: O(n log n)

def max_meetings(start, end, n):
    # create list of (end, start, position)
    intervals = []
    for i in range(n):
        intervals.append((end[i], start[i], i + 1))

    # sort by end time
    intervals.sort()

    ans = []
    ans.append(intervals[0][2])   # first meeting position
    last_end = intervals[0][0]

    for i in range(1, n):
        if intervals[i][1] > last_end:
            ans.append(intervals[i][2])
            last_end = intervals[i][0]

    return ans


# ------------------ Test (Same as Java main) ------------------

n = 6
start = [1, 3, 0, 5, 8, 5]
end = [2, 4, 5, 7, 9, 9]

print(max_meetings(start, end, n))
