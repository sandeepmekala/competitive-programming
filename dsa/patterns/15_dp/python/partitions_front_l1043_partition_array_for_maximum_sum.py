# DP / Front Partition DP
#
# Problem: https://leetcode.com/problems/partition-array-for-maximum-sum/

def maxSumAfterPartitioning(num, k):
    n = len(num)
    dp = [0] * (n + 1)

    for ind in range(n - 1, -1, -1):
        length = 0
        maxi = float('-inf')
        maxAns = float('-inf')

        for j in range(ind, min(ind + k, n)):
            length += 1
            maxi = max(maxi, num[j])
            curr_sum = length * maxi + dp[j + 1]
            maxAns = max(maxAns, curr_sum)

        dp[ind] = maxAns

    return dp[0]


def maxSumAfterPartitioning2(nums, k):
    return maxSumAfterPartitioning2Helper(0, nums, k)


def maxSumAfterPartitioning2Helper(ind, num, k):
    n = len(num)

    # base case:
    if ind == n:
        return 0

    length = 0
    maxi = float('-inf')
    maxAns = float('-inf')

    for j in range(ind, min(ind + k, n)):
        length += 1
        maxi = max(maxi, num[j])
        curr_sum = length * maxi + maxSumAfterPartitioning2Helper(j + 1, num, k)
        maxAns = max(maxAns, curr_sum)

    return maxAns


# -------- Test --------
nums = [1, 15, 7, 9, 2, 5, 10]
k = 3
print(maxSumAfterPartitioning(nums, k))    # Expected: 84
print(maxSumAfterPartitioning2(nums, k))   # Expected: 84
