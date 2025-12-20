# DP / Fibonacci
#
# Problem: https://leetcode.com/problems/climbing-stairs/
# Idea: The nth stair you can reach from n-1 or n-2 stair.
# So take the number of ways to reach n-1 and n-2 stairs. This recursively goes till base case for n-1 and n-2 cases.
# Time: O(n)
# Space: O(n)

def climb_stairs(n):
    dp = [0] * (n + 1)

    dp[0] = 1
    dp[1] = 1

    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[n]


# DP with variable jumps
#
# n = total stairs
# x = allowed jumps
#
# Time: O(n * len(x))
# Space: O(n)

def stairchasesXBottomUp(n, x):
    dp = [0] * (n + 1)
    dp[0] = 1

    for i in range(1, n + 1):
        total = 0
        for jump in x:
            if i - jump >= 0:
                total += dp[i - jump]
        dp[i] = total

    return dp[n]


# -------- Test --------
print(climb_stairs(3))                       # Expected: 3
print(stairchasesXBottomUp(4, [1, 3, 5]))    # Expected: 3
