# PrefixSum L560 - Subarray Sum Equals K
#
# Problem: https://leetcode.com/problems/subarray-sum-equals-k/
# Similar: Count number of Subarray with given xor k
#
# Idea:
# - Use prefix sum with hashmap
# - If (current_sum - k) exists, it contributes to the answer
#
# Time: O(n)
# Space: O(n)


def subarray_sum(nums, k):
    count = 0
    sum = 0
    prefix_count = {0: 1}  # prefix_sum -> frequency

    for num in nums:
        sum += num

        # Check if there exists a prefix sum such that
        # current_sum - prefix_sum = k
        count += prefix_count.get(sum - k, 0)

        # Record current prefix sum
        prefix_count[sum] = prefix_count.get(sum, 0) + 1

    return count


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 1, 1]
    k = 2
    print(subarray_sum(nums, k))  # Output: 2
