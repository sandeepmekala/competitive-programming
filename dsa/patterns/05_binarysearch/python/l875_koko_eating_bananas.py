# LeetCode 875 - Koko Eating Bananas
#
# Idea:
# Binary search on eating speed k.
# - Minimum speed = 1
# - Maximum speed = max(piles)
#
# For a given speed k, compute total hours required.
# If hours <= h, try smaller k.
# Else, increase k.
#
# Time Complexity: O(n log max(piles))
# Space Complexity: O(1)

import math


def hours_required(piles: list[int], speed: int) -> int:
    hours = 0
    for pile in piles:
        hours += math.ceil(pile / speed)
    return hours


def min_eating_speed(piles: list[int], h: int) -> int:
    left, right = 1, max(piles)
    ans = right

    while left <= right:
        mid = (left + right) // 2

        if hours_required(piles, mid) <= h:
            ans = mid
            right = mid - 1   # try slower speed
        else:
            left = mid + 1    # need faster speed

    return ans


# Driver code
if __name__ == "__main__":
    piles = [3, 6, 7, 11]
    h = 8
    print(min_eating_speed(piles, h))  # 4
