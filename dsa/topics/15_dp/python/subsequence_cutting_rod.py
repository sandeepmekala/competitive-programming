# DP / Subsequence
#
# Problem: Maximize profit by cutting rods into specific lengths
# Idea: Same as unbounded knapsack
#
#   dp[i][j] = max(
#       dp[i-1][j],                 # not pick
#       profit[i] + dp[i][j - lens[i]]  # pick
#   )
# Time: O(n*length)
# Space: O(n*length)

def cuttingRod_recursive(lens, profits, ind, length):
    if ind == 0:
        if length % lens[0] == 0:
            return (length // lens[0]) * profits[0]
        return float('-inf')
    notPick = cuttingRod_recursive(lens, profits, ind - 1, length)
    pick = float('-inf')
    if lens[ind] <= length:
        pick = profits[ind] + cuttingRod_recursive(lens, profits, ind, length - lens[ind])
    return max(notPick, pick)

def cuttingRod_dp(lens, profits, length):
    n = len(lens)
    dp = [[0] * (length + 1) for _ in range(n)]

    for i in range(n):
        for j in range(length + 1):
            if i == 0:
                if j % lens[0] == 0:
                    dp[0][j] = (j // lens[0]) * profits[0]
            else:
                notPick = dp[i - 1][j]
                pick = float('-inf')
                if lens[i] <= j:
                    pick = profits[i] + dp[i][j - lens[i]]
                dp[i][j] = max(notPick, pick)

    return dp[n - 1][length]


# -------- Test --------
lens = [1, 2, 3, 4]
profits = [2, 5, 7, 8]
length = 5

print(cuttingRod_recursive(lens, profits, len(lens) - 1, length))  # Recursive
print(cuttingRod_dp(lens, profits, length))                         # DP
