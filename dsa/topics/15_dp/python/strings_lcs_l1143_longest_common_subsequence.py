# DP / Strings
#
# Problem: https://leetcode.com/problems/longest-common-subsequence/
# Idea:
#   - If chars match: 1 + LCS of remaining substrings
#   - Else: max(LCS excluding char from str1, LCS excluding char from str2)
# Time: O(m*n)
# Space: O(m*n)

def longestCommonSubsequenceRecursive(str1, str2, i=None, j=None):
    if i is None and j is None:
        i, j = len(str1), len(str2)
    if i == 0 or j == 0:
        return 0
    if str1[i - 1] == str2[j - 1]:
        return 1 + longestCommonSubsequenceRecursive(str1, str2, i - 1, j - 1)
    else:
        return max(
            longestCommonSubsequenceRecursive(str1, str2, i - 1, j),
            longestCommonSubsequenceRecursive(str1, str2, i, j - 1)
        )

def longestCommonSubsequenceDP(str1, str2):
    m, n = len(str1), len(str2)
    lcs = [[0] * (n + 1) for _ in range(m + 1)]

    # Fill DP table
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if str1[i - 1] == str2[j - 1]:
                lcs[i][j] = 1 + lcs[i - 1][j - 1]
            else:
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])

    lcs_str = reconstructLCS(lcs, str1, str2)
    print(lcs_str)
    return lcs[m][n]

def reconstructLCS(lcs, str1, str2):
    i, j = len(str1), len(str2)
    lcs_chars = []

    while i > 0 and j > 0:
        if str1[i - 1] == str2[j - 1]:
            lcs_chars.append(str1[i - 1])
            i -= 1
            j -= 1
        elif lcs[i - 1][j] > lcs[i][j - 1]:
            i -= 1
        else:
            j -= 1

    return ''.join(reversed(lcs_chars))


# -------- Test --------
str1 = "BATD"
str2 = "ABACD"

print(longestCommonSubsequenceRecursive(str1, str2))  # Recursive LCS
print(longestCommonSubsequenceDP(str1, str2))         # DP LCS + reconstruction
