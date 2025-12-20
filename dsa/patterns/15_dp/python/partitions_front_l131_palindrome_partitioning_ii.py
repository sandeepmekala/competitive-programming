# DP / Partition DP (Front Partitioning)
#
# Problem: https://leetcode.com/problems/palindrome-partitioning-ii/
# Idea: Partition at every index and check if the partition is palindrome.

def minCut(str):
    n = len(str)
    dp = [0] * (n + 1)
    dp[n] = 0

    for i in range(n - 1, -1, -1):
        minCost = float('inf')
        # String[i...j]
        for j in range(i, n):
            if isPalindrome(str, i, j):
                cost = 1 + dp[j + 1]
                minCost = min(minCost, cost)
        dp[i] = minCost

    return dp[0] - 1


def minCut2(str):
    n = len(str)
    return minCut2Helper(0, n, str) - 1


def minCut2Helper(i, n, str):
    # Base case:
    if i == n:
        return 0

    minCost = float('inf')
    # String[i...j]
    for j in range(i, n):
        if isPalindrome(str, i, j):
            cost = 1 + minCut2Helper(j + 1, n, str)
            minCost = min(minCost, cost)

    return minCost


# Idea: Same like finding longest palindrome. start l=0,....n
# Check if str[i:j] is palindrome, if not, check for every position (k)
# in the str[i:j] and take the min if that position gives min partition.
def minCut3(s):
    n = len(s)
    mem = [[0] * n for _ in range(n)]

    for l in range(n):
        for i in range(n - l):
            j = i + l
            if isPalindrome(s, i, j):
                mem[i][j] = 0
            else:
                minimum = float('inf')
                for k in range(i, j):
                    minimum = min(minimum, 1 + mem[i][k] + mem[k + 1][j])
                mem[i][j] = minimum

    return mem[0][n - 1]


def isPalindrome(str, i, j):
    while i < j:
        if str[i] != str[j]:
            return False
        i += 1
        j -= 1
    return True


# -------- Test --------
str_val = "BABABCBADCEDE"

print(minCut(str_val))
print(minCut2(str_val))
print(minCut3(str_val))
