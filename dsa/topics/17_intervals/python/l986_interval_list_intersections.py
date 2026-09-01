# Problem: https://leetcode.com/problems/interval-list-intersections/
# Idea: Use two pointers and check if two intervals from lists overlap using criss crossing.
# Take the max of starts and min of ends to find the intersection interval.
# Move the pointer whose interval is ending first because a longer interval
# might intersect with subsequent intervals.
def interval_intersection(first, second):
    m = len(first)
    n = len(second)

    result = []
    i = 0
    j = 0

    while i < m and j < n:
        # Check for overlap (criss crossing)
        if second[j][0] <= first[i][1] and second[j][1] >= first[i][0]:
            start = max(first[i][0], second[j][0])
            end = min(first[i][1], second[j][1])
            result.append([start, end])

        # Move the pointer which ends first
        if first[i][1] < second[j][1]:
            i += 1
        else:
            j += 1

    return result


# ------------------ Test (Same as Java main) ------------------

first_list = [[0, 2], [5, 10], [13, 23], [24, 25]]
second_list = [[1, 5], [8, 12], [15, 24], [25, 26]]

res = interval_intersection(first_list, second_list)
for interval in res:
    print(interval)
