# DP / Strings
#
# Problem: https://leetcode.com/problems/shortest-common-supersequence/
# Idea:
#   - Supersequence = both strings combined, counting common chars once
#   - Use LCS to find common characters
#   - Reconstruct SCS by traversing LCS table
# Time: O(m*n)
# Space: O(m*n)

def shortestCommonSupersequence(text1, text2):
    m, n = len(text1), len(text2)
    lcs = [[0] * (n + 1) for _ in range(m + 1)]

    # Compute LCS
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if text1[i - 1] == text2[j - 1]:
                lcs[i][j] = 1 + lcs[i - 1][j - 1]
            else:
                lcs[i][j] = max(lcs[i - 1][j], lcs[i][j - 1])

    # Reconstruct SCS from LCS table
    i, j = m, n
    scs = []
    while i > 0 and j > 0:
        if text1[i - 1] == text2[j - 1]:
            scs.append(text1[i - 1])
            i -= 1
            j -= 1
        elif lcs[i - 1][j] > lcs[i][j - 1]:
            scs.append(text1[i - 1])
            i -= 1
        else:
            scs.append(text2[j - 1])
            j -= 1

    while i > 0:
        scs.append(text1[i - 1])
        i -= 1
    while j > 0:
        scs.append(text2[j - 1])
        j -= 1

    return ''.join(reversed(scs))


# -------- Test --------
text1 = "abac"
text2 = "cab"

print(shortestCommonSupersequence(text1, text2))  # Expected: "cabac"
