# DP / Strings
#
# Idea:
#   - Keep the longest common subsequence (LCS) intact
#   - Delete characters from s1 not in LCS
#   - Insert characters from s2 not in LCS
#   - Total operations = deletions + insertions = (m - LCS) + (n - LCS) = m + n - 2*LCS
# Time: O(m*n)
# Space: O(m*n)

def minOperations(str1, str2):
    m, n = len(str1), len(str2)
    lcs_len = longestCommonSubsequence(str1, str2)
    return (m + n) - 2 * lcs_len

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
str1 = "abcd"
str2 = "anc"

print(minOperations(str1, str2))  # Expected: 3 (delete b,d; insert n)
