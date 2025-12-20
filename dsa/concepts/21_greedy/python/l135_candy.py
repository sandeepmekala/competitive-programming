# Greedy
# Problem: https://leetcode.com/problems/candy/
# Idea:
# Give candies by tracking increasing (peak) and decreasing (down) slopes.
# 1. Equal ratings → give 1 candy
# 2. Increasing slope → keep increasing candies
# 3. Decreasing slope → assign 1,2,3... and adjust peak if needed
# Time: O(n)
# Space: O(1)

def candy(ratings):
    n = len(ratings)
    total = 1
    i = 1

    while i < n:
        # equal ratings
        if ratings[i] == ratings[i - 1]:
            total += 1
            i += 1
            continue

        # increasing slope
        peak = 1
        while i < n and ratings[i] > ratings[i - 1]:
            peak += 1
            total += peak
            i += 1

        # decreasing slope
        down = 1
        while i < n and ratings[i] < ratings[i - 1]:
            total += down
            down += 1
            i += 1

        # fix peak if downward slope is longer
        if down > peak:
            total += (down - peak)

    return total


# -------- Test --------
print(candy([1, 0, 2]))  # Expected: 5
