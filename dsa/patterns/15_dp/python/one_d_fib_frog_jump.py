# DP / Fibonacci
#
# Problem: https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
# Time: O(n)
# Space: O(n)

def frog_jump(heights):
    n = len(heights)
    dp = [-1] * n

    dp[0] = 0
    for ind in range(1, n):
        jump1 = dp[ind - 1] + abs(heights[ind] - heights[ind - 1])

        jump2 = float('inf')
        if ind > 1:
            jump2 = dp[ind - 2] + abs(heights[ind] - heights[ind - 2])

        dp[ind] = min(jump1, jump2)

    return dp[n - 1]


def frog_jump_memo(ind, height, dp):
    if ind == 0:
        return 0

    if dp[ind] != -1:
        return dp[ind]

    jump1 = frog_jump_memo(ind - 1, height, dp) + abs(height[ind] - height[ind - 1])

    jump2 = float('inf')
    if ind > 1:
        jump2 = frog_jump_memo(ind - 2, height, dp) + abs(height[ind] - height[ind - 2])

    dp[ind] = min(jump1, jump2)
    return dp[ind]


# -------- Test --------
height = [30, 10, 60, 10, 60, 50]
n = len(height)
dp = [-1] * n

print(frog_jump_memo(n - 1, height, dp))  # Expected: 40
print(frog_jump(height))                  # Expected: 40
