# Problem: https://leetcode.com/problems/palindromic-substrings/
# Idea: Same as longest polindromic substring. Solvable using expand around center approach and DP.
# Instead of tracking longest, count all the polindromes.
def count_substrings(s):
    count = 0
    for i in range(len(s)):
        count += expand_around_center(s, i, i)       # odd length palindromes
        count += expand_around_center(s, i, i + 1)   # even length palindromes
    return count


def expand_around_center(s, l, r):
    count = 0
    while l >= 0 and r < len(s):
        if s[l] != s[r]:
            break
        count += 1
        l -= 1
        r += 1
    return count


# DP
def count_substrings2(s):
    n = len(s)
    mem = [[False] * n for _ in range(n)]

    count = 0
    for l in range(n):
        for i in range(n - l):
            j = i + l

            if i == j:
                mem[i][j] = True                     # handles "b"
            elif s[i] == s[j]:
                if l == 1:                           # handles "bb"
                    mem[i][j] = True
                else:
                    mem[i][j] = mem[i + 1][j - 1]

            i
