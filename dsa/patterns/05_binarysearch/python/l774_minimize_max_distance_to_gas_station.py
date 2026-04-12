# LeetCode 774 - Minimize Max Distance to Gas Station
#
# Idea:
# Binary search on the answer (maximum allowed distance).
# For a guessed distance 'd', compute how many extra stations
# are required so that no segment exceeds 'd'.
#
# Time Complexity: O(n * log(range / precision))
# Space Complexity: O(1)

import math


def stations_required(stations: list[int], max_dist: float) -> int:
    required = 0

    for i in range(len(stations) - 1):
        gap = stations[i + 1] - stations[i]
        required += math.ceil(gap / max_dist) - 1   # [1, 2] 0.5 dist, we can 1

    return required


def minmax_gas_dist(stations: list[int], k: int) -> float:
    left = 0.0

    right = 0.0
    for i in range(len(stations) - 1):
        right = max(right, stations[i + 1] - stations[i])  # Max dist of adj

    ans = 0.0
    eps = 1e-6

    while right - left > eps:
        mid = (left + right) / 2.0

        if stations_required(stations, mid) <= k:  # k or fewer stations
            ans = mid
            right = mid  # minimize dist
        else:
            left = mid

    return ans


# Driver code
if __name__ == "__main__":
    stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    k = 9
    print(minmax_gas_dist(stations, k))  # ~0.5
