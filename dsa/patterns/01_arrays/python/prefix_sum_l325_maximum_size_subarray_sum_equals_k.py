# PrefixSum L325 - Maximum Size Subarray Sum Equals K
#
# Problem: https://algo.monster/liteproblems/325
#
# Idea:
# - Use prefix sum + hashmap
# - Store earliest index for each prefix sum
# - If (current_sum - k) exists, a valid subarray is found
#
# Time: O(n)
# Space: O(n)


# Approach 1: Using HashMap for prefix sum
# Works for negative numbers too
def max_sub_array_len(nums, k):

    prefix_index = {0: -1}  # prefix_sum -> earliest index
    max_len = 0
    sum = 0

    for i, num in enumerate(nums):
        sum += num

        if sum - k in prefix_index:
            max_len = max(max_len, i - prefix_index[sum - k])

        # Store only the first occurrence to maximize length
        if sum not in prefix_index:
            prefix_index[sum] = i

    return max_len


# Approach 2: Two pointers
# Doesn't work for negative numbers
# Time: O(n), Space: O(1)
def max_sub_array_len_two_pointers(nums, k):

    left = 0
    running_sum = 0
    max_len = 0

    for right, num in enumerate(nums):
        running_sum += num

        while running_sum > k:
            running_sum -= nums[left]
            left += 1

        if running_sum == k:
            max_len = max(max_len, right - left + 1)

    return max_len


# -------------------- TEST --------------------
if __name__ == "__main__":
    arr = [1, -1, 5, -2, 3]
    k = 3
    print(max_sub_array_len(arr, k))  # Output: 4
