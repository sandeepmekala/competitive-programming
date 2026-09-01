# DP / Strings
#
# Problem: https://leetcode.com/problems/longest-palindromic-subsequence/
# Idea:
#   - Method 1: Reverse string and find LCS with original string
#   - Method 2: DP on substring: 
#       - If s[i] == s[j]: 2 + dp[i+1][j-1]
#       - Else: max(dp[i+1][j], dp[i][j-1])
# Time: O(n^2)
# Space: O(n^2)

def longestPalindromeSubseq_LCS(s):
    t = s[::-1]
    return longestCommonSubsequence(s, t)

def longestCommonSubsequence(text1, text2):
    m, n = len(text1), len(text2)
    lcs = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if text1[i - 1] == text2[j - 1]:
                lcs[i][j] = 1 + lcs[i - 1][j - 1]
            else:
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])
    return lcs[m][n]

def longestPalindromeSubseq_DP(s):
    n = len(s)
    mem = [[0] * n for _ in range(n)]

    for l in range(n):
        for i in range(n - l):
            j = i + l
            if i == j:
                mem[i][j] = 1
            elif s[i] == s[j]:
                mem[i][j] = 2 + mem[i + 1][j - 1]
            else:
                mem[i][j] = max(mem[i + 1][j], mem[i][j - 1])
    return mem[0][n - 1]

def longestPalindromeSubseq_Recursive(s, i=0, j=None):
    if j is None:
        j = len(s) - 1
    if j == i:
        return 1
    elif j < i:
        return 0
    elif s[i] == s[j]:
        return 2 + longestPalindromeSubseq_Recursive(s, i + 1, j - 1)
    else:
        return max(longestPalindromeSubseq_Recursive(s, i + 1, j),
                   longestPalindromeSubseq_Recursive(s, i, j - 1))


# -------- Test --------
s = "agbdba"

print(longestPalindromeSubseq_Recursive(s))  # Expected: 5
print(longestPalindromeSubseq_DP(s))         # Expected: 5
print(longestPalindromeSubseq_LCS(s))        # Expected: 5
