# L930 - Binary Subarrays With Sum
#
# Problem: https://leetcode.com/problems/binary-subarrays-with-sum/
# Idea: numSubarraysWithSum(nums, goal) = numSubarraysWithSumLessThenOrEqual(nums, goal) -
#       numSubarraysWithSumLessThenOrEqual(nums, goal-1)
# Time: O(n)
# Space: O(1)

def num_subarrays_with_sum(nums: list[int], goal: int) -> int:
    return (
        num_subarrays_with_sum_less_than_or_equal(nums, goal)
        - num_subarrays_with_sum_less_than_or_equal(nums, goal - 1)
    )

# Count num of sub arrays with sum <= k


def num_subarrays_with_sum_less_than_or_equal(nums: list[int], goal: int) -> int:
    if goal < 0:
        return 0

    left = 0
    curr_sum = 0
    count = 0

    for right, num in enumerate(nums):
        curr_sum += num

        while curr_sum > goal:
            curr_sum -= nums[left]
            left += 1

        # all subarrays ending at `right` and starting from [left..right] are valid.
        # sum <= k
        count += (right - left + 1)

    return count


if __name__ == "__main__":
    nums = [1, 0, 1, 0, 1]
    goal = 2
    print(f"Input: nums = {nums}, goal = {goal}")
    print(f"Output: {num_subarrays_with_sum(nums, goal)}")
