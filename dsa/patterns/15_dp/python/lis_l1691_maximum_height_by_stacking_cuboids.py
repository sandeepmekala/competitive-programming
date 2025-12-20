# Problem: https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
# Idea: A concept is longest increase subsequence can be applied with i and
# j pointers. Update the max of i if it can be places on top of j box.
# A box can be rotated. So rotate the box with max height possible.
# Sort the cuboids  in decreasing volume order.
# Time: O(3*n) = O(n)
# Space: O(3*n) = O(n)

def maxHeight(cuboids):
    n = len(cuboids)

    # rotate each cuboid so that height is maximized
    for cube in cuboids:
        cube.sort()  # [36,46,41] -> [36,41,46]

    # sort based on volume in descending order so bigger cuboid is at bottom
    cuboids.sort(key=lambda c: c[0] * c[1] * c[2], reverse=True)

    # max[i] = maximum height with cuboid i at the top
    max_dp = [0] * n
    for i in range(n):
        max_dp[i] = cuboids[i][2]

    maxHeight = cuboids[0][2]

    for i in range(1, n):
        for j in range(i):
            if (cuboids[i][0] <= cuboids[j][0] and
                cuboids[i][1] <= cuboids[j][1] and
                cuboids[i][2] <= cuboids[j][2]):
                max_dp[i] = max(max_dp[i], max_dp[j] + cuboids[i][2])

        if max_dp[i] > maxHeight:
            maxHeight = max_dp[i]

    return maxHeight


# -------- Test (same as Java main) --------
boxes = [
    [36, 46, 41],
    [15, 100, 100],
    [75, 91, 59],
    [13, 82, 64]
]

print(maxHeight(boxes))
