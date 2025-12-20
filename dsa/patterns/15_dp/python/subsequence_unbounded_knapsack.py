# DP / Recursion
# Problem: https://bit.ly/3IvPdXS
# Idea:
# 1. For each item, you can either pick it multiple times (unbounded) or skip it.
# 2. Recursion: if we pick, stay on same index; if not pick, move to previous index.
# 3. DP tabulation stores max value for each item and capacity.
# Time: O(n*W)
# Space: O(n*W)

def unbounded_knapsack_dp(n, w, val, wt):
    dp = [[0] * (w + 1) for _ in range(n)]

    # Base case: only first item available
    for cap in range(wt[0], w + 1):
        dp[0][cap] = (cap // wt[0]) * val[0]

    for ind in range(1, n):
        for cap in range(w + 1):
            not_taken = dp[ind - 1][cap]
            taken = float('-inf')
            if wt[ind] <= cap:
                taken = val[ind] + dp[ind][cap - wt[ind]]
            dp[ind][cap] = max(not_taken, taken)

    return dp[n - 1][w]


def unbounded_knapsack_recursive(wt, val, ind, weight):
    if ind == 0:
        return (weight // wt[0]) * val[0]

    not_taken = unbounded_knapsack_recursive(wt, val, ind - 1, weight)
    taken = float('-inf')
    if wt[ind] <= weight:
        taken = val[ind] + unbounded_knapsack_recursive(wt, val, ind, weight - wt[ind])

    return max(not_taken, taken)


# -------- Test --------
wt = [2, 4, 6]
val = [5, 11, 13]
weight = 10
n = len(wt)

print(unbounded_knapsack_dp(n, weight, val, wt))                 # DP approach
print(unbounded_knapsack_recursive(wt, val, n - 1, weight))      # Recursive approach
