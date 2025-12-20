# Problem: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
# Idea: This is similar to Activity Selection problem.
# All the overlapping balloons can be bursted with one arrow.
# So the count will be count of non-overlapping balloons.
# Sort the balloons based on end time and pick a new arrow
# only when the next balloon starts after the last arrow position.
def find_min_arrow_shots(points):
    n = len(points)
    if n == 0:
        return 0

    # sort by end coordinate
    points.sort(key=lambda x: x[1])

    cnt = 1
    last_end = points[0][1]

    for i in range(1, n):
        if points[i][0] >= last_end:
            cnt += 1
            last_end = points[i][1]

    return cnt


# ------------------ Test (Same as Java main) ------------------

# points = [[10,16],[2,8],[1,6],[7,12]]
points = [[-2147483646, -2147483645], [2147483646, 2147483647]]
print(find_min_arrow_shots(points))  # Expected: 2
