# DP / Subsequence
#
# Problem: https://leetcode.com/problems/coin-change/
# Minimum number of coins required to make the total. Unlimited supply of coins.
# Idea: Same as unbounded knapsack
#
# dp[i][j] = min(
#     dp[i-1][j],          # not pick
#     1 + dp[i][j - coins[i]]  # pick current coin
# )
# Time: O(n*total)
# Space: O(n*total)

def coinChange_recursive(coins, ind, total):
    if ind == 0:
        if total % coins[0] == 0:
            return total // coins[0]
        return int(1e9)

    notPick = coinChange_recursive(coins, ind - 1, total)
    pick = int(1e9)
    if coins[ind] <= total:
        pick = 1 + coinChange_recursive(coins, ind, total - coins[ind])

    return min(notPick, pick)

def coinChange_dp(coins, total):
    n = len(coins)
    dp = [[0] * (total + 1) for _ in range(n)]

    for i in range(n):
        for t in range(1, total + 1):
            if i == 0:
                if t % coins[0] == 0:
                    dp[0][t] = t // coins[0]  # can use only coin[0]
                else:
                    dp[0][t] = int(1e9)
            else:
                notPick = dp[i - 1][t]
                pick = int(1e9)
                if coins[i] <= t:
                    pick = 1 + dp[i][t - coins[i]]
                dp[i][t] = min(notPick, pick)

    return -1 if dp[n - 1][total] >= int(1e9) else dp[n - 1][total]


# -------- Test --------
coins = [5, 1, 6, 8]
total = 11

print(coinChange_recursive(coins, len(coins) - 1, total))  # Recursive
print(coinChange_dp(coins, total))                         # DP
