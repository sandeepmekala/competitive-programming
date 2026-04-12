# L1248 - Count Number of Nice Subarrays
#
# Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
# Idea: It is same as binary subarrays with sum k as you can replace all odd numbers with 1 and even numbers with 0
# Time: O(n)
# Space: O(1)

def number_of_subarrays(nums: list[int], k: int) -> int:
    return (
        num_subarrays_with_sum_less_than_or_equal(nums, k)
        - num_subarrays_with_sum_less_than_or_equal(nums, k - 1)
    )


def num_subarrays_with_sum_less_than_or_equal(nums: list[int], k: int) -> int:
    if k < 0:
        return 0

    left = 0
    odd_count = 0
    count = 0

    for right, value in enumerate(nums):
        odd_count += value % 2  # Count odd numbers as 1, even as 0

        while odd_count > k:
            odd_count -= nums[left] % 2
            left += 1

        # all subarrays ending at `right` and starting from [left..right] are valid
        count += right - left + 1

    return count


if __name__ == "__main__":
    nums = [1, 1, 2, 1, 1]
    k = 3
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {number_of_subarrays(nums, k)}")
