"""
LeetCode 774 - Minimize Max Distance to Gas Station

Idea:
Binary search on the answer (maximum allowed distance).
For a guessed distance 'd', compute how many extra stations
are required so that no segment exceeds 'd'.

Time Complexity: O(n * log(range / precision))
Space Complexity: O(1)
"""

import math


def stations_required(stations, dist):
    count = 0
    for i in range(len(stations) - 1):
        gap = stations[i + 1] - stations[i]
        count += math.ceil(gap / dist) - 1
    return count


def minmax_gas_dist(stations, k):
    # Binary search range
    low, high = 0.0, 0.0

    # Max initial distance between consecutive stations
    for i in range(len(stations) - 1):
        high = max(high, stations[i + 1] - stations[i])

    ans = 0.0
    eps = 1e-6

    while high - low > eps:
        mid = (low + high) / 2.0

        if stations_required(stations, mid) <= k:
            ans = mid
            high = mid
        else:
            low = mid

    return ans


# Driver code
if __name__ == "__main__":
    stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    k = 9
    print(minmax_gas_dist(stations, k))
