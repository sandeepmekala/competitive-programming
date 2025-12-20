# DP / Fibonacci
#
# Problem: https://leetcode.com/problems/min-cost-climbing-stairs/
# Idea: Every position you can reach from -1 or -2 positions by paying the cost of those positions, plus the cost of reaching those positions.
#
# T[i] = Min{
#     cost(i-1) + T[i-1],
#     cost(i-2) + T[i-2]
# }
#
# i    0   1   2   3
# c    10  15  20
#      0   0   10  15
#
# Time: O(n)
# Space: O(n)

def min_cost_climbing_stairs(cost):
    n = len(cost)
    dp = [0] * (n + 1)

    for i in range(2, n + 1):
        dp[i] = min(
            cost[i - 1] + dp[i - 1],
            cost[i - 2] + dp[i - 2]
        )

    return dp[n]


# -------- Test --------
cost = [10, 15, 20]
print(min_cost_climbing_stairs(cost))  # Expected: 15
