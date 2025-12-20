# DP / Subsequence
#
# Problem: https://leetcode.com/problems/coin-change-ii/
# Idea: Count number of ways to make total using coins (unlimited supply)
#       If total becomes 0 → return 1 (valid combination)
#       If total < 0 or index < 0 → return 0 (invalid combination)
#
# T[i][j] = T[i-1][j] + T[i][j-coins[i]]
# Time: O(n*total)
# Space: O(n*total)

def change(coins, total):
    n = len(coins)
    dp = [[0] * (total + 1) for _ in range(n)]

    for i in range(n):
        for t in range(total + 1):
            if t == 0:
                dp[i][t] = 1
            elif i == 0:
                if t % coins[0] == 0:
                    dp[i][t] = 1
            else:
                notPick = dp[i - 1][t]
                pick = 0
                if coins[i] <= t:
                    pick = dp[i][t - coins[i]]
                dp[i][t] = notPick + pick

    return dp[n - 1][total]


# Recursive version
def change_recursive(coins, ind, tot):
    if ind == 0:
        return 1 if tot % coins[0] == 0 else 0

    notPick = change_recursive(coins, ind - 1, tot)
    pick = 0
    if coins[ind] <= tot:
        pick = change_recursive(coins, ind, tot - coins[ind])

    return notPick + pick


# -------- Test --------
coins = [2, 1, 3]
total = 4
print(change(coins, total))              # Expected: 4
print(change_recursive(coins, len(coins)-1, total))  # Expected: 4
