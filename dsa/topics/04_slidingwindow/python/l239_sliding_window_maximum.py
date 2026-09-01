# L239 - Sliding Window Maximum
#
# Problem: https://leetcode.com/problems/sliding-window-maximum/
# Idea: Use monotonically decreasing deque. Maintain the nums in decreasing order in deque.
# first <- 5, 4, 3 <- last
# Take the left most to take the max for that window.
# Remove the left most if it goes out of window.
# Time: O(n)
# Space: O(k)

from collections import deque


def max_sliding_window(nums: list[int], k: int) -> list[int]:
    res = []
    dq = deque()

    for right, num in enumerate(nums):
        if dq and dq[0] <= right - k:
            dq.popleft()
        while dq and nums[dq[-1]] < num:
            dq.pop()
        dq.append(right)
        if right >= k - 1:
            res.append(nums[dq[0]])
    return res


if __name__ == "__main__":
    nums = [1, 3, -1, -3, 5, 3, 6, 7]
    k = 3
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {max_sliding_window(nums, k)}")
