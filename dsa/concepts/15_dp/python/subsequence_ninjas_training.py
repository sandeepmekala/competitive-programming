# DP / Recursion
# Problem: https://bit.ly/3F4yl8z
# Idea:
# 1. For each day, you can choose one of 3 tasks, but cannot repeat the task from previous day.
# 2. Use recursion with "last task" parameter to compute max points.
# 3. DP tabulation can be used to avoid recomputation.
# Time: O(n*4*3) for DP
# Space: O(n*4) for DP table

def ninja_training_recursive(ind, last, points):
    if ind == 0:
        # On day 0, pick max points among tasks not equal to last
        max_points = 0
        for task in range(3):
            if task != last:
                max_points = max(max_points, points[0][task])
        return max_points

    max_points = 0
    for task in range(3):
        if task != last:
            pnts = points[ind][task] + ninja_training_recursive(ind - 1, task, points)
            max_points = max(max_points, pnts)
    return max_points


def ninja_training_dp(points):
    n = len(points)
    dp = [[0]*4 for _ in range(n)]
    
    # Base case: first day
    dp[0][0] = max(points[0][1], points[0][2])
    dp[0][1] = max(points[0][0], points[0][2])
    dp[0][2] = max(points[0][0], points[0][1])
    dp[0][3] = max(points[0][0], points[0][1], points[0][2])

    for ind in range(1, n):
        for last in range(4):
            dp[ind][last] = 0
            for task in range(3):
                if task != last:
                    pnts = points[ind][task] + dp[ind - 1][task]
                    dp[ind][last] = max(dp[ind][last], pnts)

    return dp[n - 1][3]


# -------- Test --------
points = [
    [10, 40, 70],
    [20, 50, 80],
    [30, 60, 90]
]

n = len(points)
print(ninja_training_recursive(n - 1, 3, points))  # Recursive approach
print(ninja_training_dp(points))                     # DP approach
