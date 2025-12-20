from collections import defaultdict
from bisect import bisect_left

"""
Problem: https://leetcode.com/problems/the-skyline-problem/
Idea: We are interested in point of x and h. Every building has 2 of those points
at left height and right height. We are interested only in the top points as skyline
touches only those.

Start moving left to right, if you encounter a start point, push it to max structure.
If this changes max height, that point should be in the result.

Similarly, if you encounter an end point, remove it from the structure.
If that changes max height, that point should be in the result.

Points should be sorted on x.
To handle some special cases when x is same, we sort heights carefully.

We need to remove non-max elements efficiently, hence TreeMap-like behavior.
"""

def getSkyline(buildings):
    points = []

    # Create start and end points
    for left, right, height in buildings:
        points.append((left, -height))   # start point
        points.append((right, height))   # end point

    # Sort points:
    # x asc, start before end, taller start first, shorter end first
    points.sort()

    # height -> frequency (TreeMap replacement)
    height_count = defaultdict(int)
    height_count[0] = 1                  # ground level

    # sorted list of active heights
    active_heights = [0]

    result = []
    prev_max = 0

    for x, h in points:
        if h < 0:  # start point
            height = -h
            height_count[height] += 1
            _add_height(active_heights, height)
        else:      # end point
            height = h
            height_count[height] -= 1
            if height_count[height] == 0:
                del height_count[height]
                _remove_height(active_heights, height)

        curr_max = active_heights[-1]
        if curr_max != prev_max:
            result.append([x, curr_max])
            prev_max = curr_max

    return result


def _add_height(arr, h):
    idx = bisect_left(arr, h)
    arr.insert(idx, h)


def _remove_height(arr, h):
    idx = bisect_left(arr, h)
    arr.pop(idx)


if __name__ == "__main__":
    buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
    skyline = getSkyline(buildings)
    for point in skyline:
        print(point)
