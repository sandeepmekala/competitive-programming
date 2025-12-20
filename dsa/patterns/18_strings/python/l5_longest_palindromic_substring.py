# Problem: https://leetcode.com/problems/longest-palindromic-substring/
# Idea: Expand around center
# Alternative: This can be solved using DP with same complexity.
# Time: O(n^2)
def longest_palindrome(s):
    if s is None or len(s) < 1:
        return ""

    start = 0
    end = 0

    for i in range(len(s)):
        len1 = expand_around_center(s, i, i)       # aba
        len2 = expand_around_center(s, i, i + 1)   # abba
        max_len = max(len1, len2)

        if max_len > end - start:
            start = i - (max_len - 1) // 2
            end = i + max_len // 2

    return s[start:end + 1]


def expand_around_center(s, l, r):
    while l >= 0 and r < len(s):
        if s[l] != s[r]:
            break
        l -= 1
        r += 1
    return r - l - 1


# Idea: Start with l=1 and go till l=n.
# If first char and last char matches, add 2 to the length and look into the substring
# except first and last chars
# Track the max len and substring which is polindrom when max gets updated
# aba = 2+len(b) = 3
#
# Time: O(n^2)
#
#   T[i][j] = T[i+1][j-1] if str[i] == str[j]
#
# Time: O(n^2)
# Space: O(n*n)
def longest_palindrome2(s):
    n = len(s)
    dp = [[False] * n for _ in range(n)]

    max_len = 0
    palindrome = ""

    for l in range(n):
        for i in range(n - l):
            j = i + l

            if i == j:
                dp[i][j] = True                     # handles "b"
            elif s[i] == s[j]:
                if l == 1:                          # handles "bb"
                    dp[i][j] = True
                else:
                    dp[i][j] = dp[i + 1][j - 1]

            if dp[i][j] and (j - i + 1) > max_len:
                max_len = j - i + 1
                palindrome = s[i:j + 1]

    return palindrome


# ------------------ Test (Same as Java main) ------------------

s = "babad"
print(longest_palindrome(s))
print(longest_palindrome2(s))
