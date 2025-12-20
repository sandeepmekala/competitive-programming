# DP / Knapsack
#
# Problem: https://bit.ly/3KHpP3v
# Idea:
#   - State: (n, W) = max value using first n items with max weight W
#   - Pick or not pick each item
# Time: O(n*Wmax)
# Space: O(n*Wmax)

def knapsack_recursive(weights, values, ind, wmax):
    if ind == 0:
        if weights[0] <= wmax:
            return values[0]
        return 0

    notPick = knapsack_recursive(weights, values, ind - 1, wmax)
    pick = float('-inf')
    if weights[ind] <= wmax:
        pick = values[ind] + knapsack_recursive(weights, values, ind - 1, wmax - weights[ind])

    return max(notPick, pick)

def knapsack_dp(weights, values, wmax):
    n = len(weights)
    dp = [[0] * (wmax + 1) for _ in range(n)]

    for ind in range(n):
        for w in range(wmax + 1):
            if ind == 0:
                if weights[0] <= w:
                    dp[0][w] = values[0]
            else:
                notPick = dp[ind - 1][w]
                pick = float('-inf')
                if weights[ind] <= w:
                    pick = values[ind] + dp[ind - 1][w - weights[ind]]
                dp[ind][w] = max(notPick, pick)

    return dp[n - 1][wmax]


# -------- Test --------
weights = [1, 2, 3, 4, 5]
values = [5, 3, 5, 3, 2]
n = 4
wmax = 10

print(knapsack_recursive(weights, values, n - 1, wmax))  # Recursive
print(knapsack_dp(weights, values, wmax))                # DP
