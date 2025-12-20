# DP / Fibonacci
#
# Problem: https://leetcode.com/problems/fibonacci-number/
# Idea: fib(n) = fib(n-1) - fib(n-2)

def fib(n):
    prev2 = 0
    prev1 = 1

    if n <= 1:
        return n

    for i in range(2, n + 1):
        curr = prev1 + prev2
        prev2 = prev1
        prev1 = curr

    return prev1


def fib2(n):
    dp = [0] * (n + 1)
    dp[0] = 0
    dp[1] = 1

    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    return dp[n]


def fib3(n):
    if n == 0 or n == 1:
        return n

    return fib2(n - 1) + fib2(n - 2)


# -------- Test --------
print(fib(25))   # Expected: 75025
print(fib3(25))  # Expected: 75025
print(fib2(25))  # Expected: 75025
