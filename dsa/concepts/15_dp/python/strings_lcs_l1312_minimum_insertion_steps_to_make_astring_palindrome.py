# DP / Strings
#
# Problem: https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
# Idea:
#   - Find longest palindromic subsequence (LPS)
#   - Number of insertions = len(s) - LPS
# Time: O(n^2)
# Space: O(n^2)

def minInsertions(s):
    n = len(s)
    return n - longestPalindromeSubseq(s)

def longestPalindromeSubseq(s):
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


# -------- Test --------
s = "mbadm"
print(minInsertions(s))  # Expected: 2
