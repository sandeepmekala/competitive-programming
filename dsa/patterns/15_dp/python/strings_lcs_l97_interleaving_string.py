# DP / Strings
#
# Problem: https://leetcode.com/problems/interleaving-string/
# Idea:
#   - Similar to LCS
#   - If ch1 in s1 matches ch in s3 → check remaining string
#   - If ch2 in s2 matches ch in s3 → check remaining string
#
# DP state: dp[i][j] = True if s3[:i+j] can be formed by interleaving s1[:i] and s2[:j]

def isInterleave(s1, s2, s3):
    m, n = len(s1), len(s2)
    if m + n != len(s3):
        return False

    dp = [[False] * (n + 1) for _ in range(m + 1)]

    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0 and j == 0:
                dp[i][j] = True
            elif i == 0:
                dp[i][j] = dp[i][j - 1] and s2[j - 1] == s3[i + j - 1]
            elif j == 0:
                dp[i][j] = dp[i - 1][j] and s1[i - 1] == s3[i + j - 1]
            else:
                dp[i][j] = (dp[i - 1][j] and s1[i - 1] == s3[i + j - 1]) or \
                           (dp[i][j - 1] and s2[j - 1] == s3[i + j - 1])

    return dp[m][n]


# -------- Test --------
s1 = "aabcc"
s2 = "dbbca"
s3 = "aadbbcbcac"

print(isInterleave(s1, s2, s3))  # Expected: True
