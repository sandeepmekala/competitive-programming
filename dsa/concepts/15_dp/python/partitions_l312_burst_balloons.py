# DP / Partition DP
#
# Problem: https://leetcode.com/problems/burst-balloons/
# Idea: We take each position and try to burst the balloons on its left and
# right before bursting it.
# Left sub problem and right sub problems become independent if we include the
# current element also in its sub array.
# Once left and right sub problems are solved, we are left with bursting last
# balloon and last supporting balloons are at i-1 and j+1 positions.


def maxCoins2(nums):
    n = len(nums)

    # add virtual balloons with value 1 at both ends
    arr = nums[:]
    arr.insert(0, 1)
    arr.append(1)

    return maxCoins2Helper(arr, 1, n)   # n-1 shifted to n after inserting 1


def maxCoins2Helper(nums, i, j):
    if i > j:
        return 0

    maximum = 0
    for k in range(i, j + 1):
        coins = (
            nums[i - 1] * nums[k] * nums[j + 1]
            + maxCoins2Helper(nums, i, k - 1)
            + maxCoins2Helper(nums, k + 1, j)
        )
        maximum = max(maximum, coins)

    return maximum


def maxCoins(nums):
    n = len(nums)

    # add virtual balloons
    arr = nums[:]
    arr.insert(0, 1)
    arr.append(1)

    dp = [[0] * (n + 2) for _ in range(n + 2)]

    for i in range(n, 0, -1):
        for j in range(1, n + 1):
            if i > j:
                continue

            maximum = float('-inf')
            for k in range(i, j + 1):
                coin = (
                    arr[i - 1] * arr[k] * arr[j + 1]
                    + dp[i][k - 1]
                    + dp[k + 1][j]
                )
                maximum = max(maximum, coin)

            dp[i][j] = maximum

    return dp[1][n]


# -------- Test --------
nums = [3, 1, 5, 8]
print(maxCoins2(nums))  # Expected: 167
print(maxCoins(nums))   # Expected: 167
