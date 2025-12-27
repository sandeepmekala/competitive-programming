# L643 - Maximum Average Subarray I
#
# Problem: https://leetcode.com/problems/maximum-average-subarray-i/
#
# Idea:
# - Use a fixed-size sliding window of length k
# - Track the sum of the window and update the maximum average
#
# Time: O(n)
# Space: O(1)


def find_max_average(nums, k):
    window_sum = sum(nums[:k])
    max_sum = window_sum

    for i in range(k, len(nums)):
        window_sum += nums[i] - nums[i - k]
        max_sum = max(max_sum, window_sum)

    return max_sum / k


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 12, -5, -6, 50, 3]
    k = 4
    print(find_max_average(nums, k))  # Output: 12.75
