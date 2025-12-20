# DP / Strings
#
# Problem: Longest Common Substring
# Idea:
#   - If str1[i-1] == str2[j-1], extend the substring by 1 from previous dp[i-1][j-1]
#   - Keep track of the maximum length
# Time: O(m*n)
# Space: O(m*n)

def longestCommonSubstring(str1, str2):
    m, n = len(str1), len(str2)
    mem = [[0] * (n + 1) for _ in range(m + 1)]
    max_len = 0

    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if str1[i - 1] == str2[j - 1]:
                mem[i][j] = 1 + mem[i - 1][j - 1]
                max_len = max(max_len, mem[i][j])

    return max_len


# -------- Test --------
str1 = "abcdaf"
str2 = "zbcdf"

print(longestCommonSubstring(str1, str2))  # Expected: 4 ("bcd")
