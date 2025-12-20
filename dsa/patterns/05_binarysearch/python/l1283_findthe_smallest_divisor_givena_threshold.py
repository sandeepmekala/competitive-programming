"""
LeetCode 1283 - Find the Smallest Divisor Given a Threshold

Idea:
Binary search on divisor.
- Minimum divisor = 1
- Maximum divisor = max(nums)

For a guessed divisor d, compute:
    sum(ceil(num / d)) for all nums
If sum <= threshold, try smaller divisor.
Else, increase divisor.

Time Complexity: O(n log(max(nums)))
Space Complexity: O(1)
"""

import math


def divisor_sum(nums, divisor):
    total = 0
    for num in nums:
        total += math.ceil(num / divisor)
    return total


def smallest_divisor(nums, threshold):
    low, high = 1, max(nums)
    ans = high

    while low <= high:
        mid = (low + high) // 2

        if divisor_sum(nums, mid) <= threshold:
            ans = mid
            high = mid - 1   # try smaller divisor
        else:
            low = mid + 1    # need larger divisor

    return ans


# Driver code
if __name__ == "__main__":
    nums = [1, 2, 5, 9]
    threshold = 6
    print(smallest_divisor(nums, threshold))  # 5
