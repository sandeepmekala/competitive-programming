# DP / Strings
#
# Problem: https://leetcode.com/problems/distinct-subsequences/
# Idea:
#   - If s[i-1] == t[j-1]: take T[i-1][j-1] + T[i-1][j]
#   - Else: take T[i-1][j]
# Time: O(m*n)
# Space: O(m*n)

def numDistinctRecursive(s, t, i=None, j=None):
    if i is None and j is None:
        i, j = len(s), len(t)

    if j == 0:
        return 1  # empty t is a subsequence of any string
    if i == 0:
        return 0  # empty s cannot match non-empty t

    if s[i - 1] == t[j - 1]:
        return numDistinctRecursive(s, t, i - 1, j - 1) + numDistinctRecursive(s, t, i - 1, j)
    else:
        return numDistinctRecursive(s, t, i - 1, j)


def numDistinctDP(s, t):
    m, n = len(s), len(t)
    dp = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(m + 1):
        dp[i][0] = 1  # empty t is a subsequence of any prefix of s

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s[i - 1] == t[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
            else:
                dp[i][j] = dp[i - 1][j]

    return dp[m][n]


# -------- Test --------
s = "rabbbit"
t = "rabbit"

print(numDistinctDP(s, t))                  # Expected: 3
print(numDistinctRecursive(s, t, len(s), len(t)))  # Expected: 3
