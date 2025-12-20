# DP / Strings
#
# Problem: https://leetcode.com/problems/wildcard-matching/
# Idea:
#   '*' matches zero or more characters
#   '?' matches any single character
#
# DP state: match[i][j] = True if s[:i] matches p[:j]
#
# T[i][j] = {
#       T[i-1][j-1]                 if s[i-1] == p[j-1] or p[j-1] == '?'
#       T[i][j-1] or T[i-1][j]      if p[j-1] == '*'
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
                    match[i][j] = match[i][j - 1]
            elif s[i - 1] == p[j - 1] or p[j - 1] == '?':
                match[i][j] = match[i - 1][j - 1]
            elif p[j - 1] == '*':
                match[i][j] = match[i][j - 1] or match[i - 1][j]
            else:
                match[i][j] = False

    return match[n][m]


def isMatchRecursive(s, p, i=None, j=None):
    if i is None and j is None:
        i, j = len(s), len(p)

    if i == 0 and j == 0:
        return True
    if i > 0 and j == 0:
        return False
    if i == 0 and j > 0:
        for k in range(j):
            if p[k] != '*':
                return False
        return True

    if s[i - 1] == p[j - 1] or p[j - 1] == '?':
        return isMatchRecursive(s, p, i - 1, j - 1)
    if p[j - 1] == '*':
        return isMatchRecursive(s, p, i, j - 1) or isMatchRecursive(s, p, i - 1, j)

    return False


# -------- Test --------
s = "xaylmz"
p = "x?y*z"

print(isMatch(s, p))                  # Expected: True
print(isMatchRecursive(s, p, len(s), len(p)))  # Expected: True
