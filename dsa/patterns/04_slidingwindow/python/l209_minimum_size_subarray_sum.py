# L209 - Minimum Size Subarray Sum
#
# Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
# Idea: Use sliding window as it ask for contiguous sub array.
# Continuously find sum of nums, if sum goes more than target, find the min length of all possibilities.
# Time: O(n)
# Space: O(1)

def min_sub_array_len(target: int, nums: list[int]) -> int:
    left = 0
    curr_sum = 0
    min_len = float("inf")

    for right, value in enumerate(nums):
        curr_sum += value

        while curr_sum >= target:
            min_len = min(min_len, right - left + 1)
            curr_sum -= nums[left]
            left += 1

    return 0 if min_len == float("inf") else min_len


if __name__ == "__main__":
    nums = [2, 3, 1, 2, 4, 3]
    target = 7
    print(f"Input: target = {target}, nums = {nums}")
    print(f"Output: {min_sub_array_len(target, nums)}")
