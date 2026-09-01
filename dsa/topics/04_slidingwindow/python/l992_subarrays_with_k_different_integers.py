# L992 - Subarrays with K Different Integers
#
# Problem: https://leetcode.com/problems/subarrays-with-k-different-integers/
# Idea: subarraysWithKDistinct(nums, k) =
#       subarraysWithLessThenOrEqualToKDistinct(nums, k) -
#       subarraysWithLessThenOrEqualToKDistinct(nums, k-1)
# Time: O(n)
# Space: O(k)

def subarrays_with_k_distinct(nums: list[int], k: int) -> int:
    return (
        subarrays_with_less_than_or_equal_to_k_distinct(nums, k)
        - subarrays_with_less_than_or_equal_to_k_distinct(nums, k - 1)
    )


def subarrays_with_less_than_or_equal_to_k_distinct(nums: list[int], k: int) -> int:
    left = 0
    count = 0
    freq = {}

    for right, value in enumerate(nums):
        freq[value] = freq.get(value, 0) + 1

        while len(freq) > k:
            freq[nums[left]] -= 1
            if freq[nums[left]] == 0:
                del freq[nums[left]]
            left += 1

        # all subarrays ending at `right` and starting from [left..right] are valid
        count += right - left + 1

    return count


if __name__ == "__main__":
    nums = [1, 2, 1, 2, 3]
    k = 2
    print(f"Input: nums = {nums}, k = {k}")
    print(f"Output: {subarrays_with_k_distinct(nums, k)}")
