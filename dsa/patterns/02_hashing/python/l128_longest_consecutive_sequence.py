# L128 - Longest Consecutive Sequence
#
# Problem: https://leetcode.com/problems/longest-consecutive-sequence/
#
# Idea:
# - Store all numbers in a set
# - Only start counting when (num - 1) is not present
#
# Time: O(n)
# Space: O(n)


def longest_consecutive(nums):
    if not nums:
        return 0

    num_set = set(nums)
    longest = 0

    for num in num_set:  # Numbers can be repeating in nums. Better to traverse unique nums.
        # Start only if this number is the beginning of a sequence
        if num - 1 not in num_set:
            current = num
            length = 1

            while current + 1 in num_set:
                current += 1
                length += 1

            longest = max(longest, length)

    return longest


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [100, 4, 200, 1, 3, 2]
    print(longest_consecutive(nums))  # Output: 4
