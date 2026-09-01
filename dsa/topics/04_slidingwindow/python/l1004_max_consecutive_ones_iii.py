# L1004 - Max Consecutive Ones III
#
# Problem: https://leetcode.com/problems/max-consecutive-ones-iii/
# Idea: This can be reframed as find the longest subarray with at most k zeros
# Time: O(n)
# Space: O(1)

def longest_ones(nums: list[int], k: int) -> int:
    left = 0
    zeros = 0
    max_len = 0

    for right, num in enumerate(nums):
        if num == 0:
            zeros += 1

        if zeros > k:
            if nums[left] == 0:
                zeros -= 1
            left += 1

        # zeros <= k always holds here
        max_len = max(max_len, right - left + 1)

    return max_len


if __name__ == "__main__":
    nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
    k = 2
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {longest_ones(nums, k)}")
