# DP / Strings
#
# Problem: https://leetcode.com/problems/regular-expression-matching/
# Idea:
# '*' matches 0 or more occurrences of the preceding character
# '.' matches any single character
# DP state: match[i][j] = True if s[:i] matches p[:j]
#
# T[i][j] = {
#       T[i-1][j-1]                                             if s[i-1] == p[j-1] or p[j-1] == '.'
#       (T[i][j-2] or (T[i-1][j] if s[i-1] == p[j-2] or p[j-2] == '.'))  if p[j-1] == '*'
# }

def isMatch(s, p):
    n, m = len(s), len(p)
    match = [[False] * (m + 1) for _ in range(n + 1)]

    for i in range(n + 1):
        for j in range(m + 1):
            if i == 0 and j == 0:
                match[i][j] = True
            elif j == 0:
                match[i][j] = False
            elif i == 0:
                if p[j - 1] == '*':
                    match[i][j] = match[i][j - 2]
            elif s[i - 1] == p[j - 1] or p[j - 1] == '.':
                match[i][j] = match[i - 1][j - 1]
            elif p[j - 1] == '*':
                match[i][j] = match[i][j - 2] or ((s[i - 1] == p[j - 2] or p[j - 2] == '.') and match[i - 1][j])
            else:
                match[i][j] = False

    return match[n][m]


# -------- Test --------
s = "xabyc"
p = "xa*b.c"

print(isMatch(s, p))  # Expected: True
