# LeetCode 410 - Split Array Largest Sum
# (Book Allocation / Painter's Partition variant)
#
# Idea:
# Binary search on the answer.
# - Minimum possible max sum = max(nums)
# - Maximum possible max sum = sum(nums)
#
# Check feasibility by counting how many subarrays
# (students) are needed for a given max sum.
#
# Time Complexity: O(n log(sum(nums)))
# Space Complexity: O(1)

def can_split(nums: list[int], k, max_sum: int) -> int:
    sub_arrays = 1
    current_sum = 0

    for num in nums:
        if current_sum + num <= max_sum:
            current_sum += num
        else:
            sub_arrays += 1
            current_sum = num

    return sub_arrays <= k


def split_array(nums: list[int], k: int) -> int:
    # Impossible to split
    if k > len(nums):
        return -1

    left, right = max(nums), sum(nums)
    ans = right

    while left <= right:
        mid = (left + right) // 2

        if can_split(nums, k, mid):
            ans = mid
            right = mid - 1   # try to minimize further
        else:
            left = mid + 1

    return ans


# Driver code
if __name__ == "__main__":
    nums = [25, 46, 28, 49, 24]
    m = 4
    print(split_array(nums, m))  # 71
