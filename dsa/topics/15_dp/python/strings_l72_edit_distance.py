# DP / Strings
#
# Problem: https://leetcode.com/problems/edit-distance/
# Convert word1 to word2 using Insert, Delete, or Replace
# Idea:
#   - If chars match: take diagonal value T[i-1][j-1]
#   - Else: consider all 3 operations and take minimum
# Time: O(m*n)
# Space: O(m*n)

def minDistanceRecursive(word1, word2, i=None, j=None):
    if i is None and j is None:
        i, j = len(word1), len(word2)

    # Base cases
    if i == 0:
        return j  # Insert all remaining chars of word2
    if j == 0:
        return i  # Delete all remaining chars of word1

    if word1[i - 1] == word2[j - 1]:
        return minDistanceRecursive(word1, word2, i - 1, j - 1)
    else:
        delete = minDistanceRecursive(word1, word2, i - 1, j)      # delete word1 char
        insert = minDistanceRecursive(word1, word2, i, j - 1)      # insert word2 char
        replace = minDistanceRecursive(word1, word2, i - 1, j - 1) # replace word1 char
        return 1 + min(delete, insert, replace)


def minDistanceDP(word1, word2):
    m, n = len(word1), len(word2)
    mem = [[0] * (n + 1) for _ in range(m + 1)]

    for i in range(m + 1):
        for j in range(n + 1):
            if i == 0:
                mem[i][j] = j  # Insert all remaining chars of word2
            elif j == 0:
                mem[i][j] = i  # Delete all remaining chars of word1
            elif word1[i - 1] == word2[j - 1]:
                mem[i][j] = mem[i - 1][j - 1]
            else:
                mem[i][j] = 1 + min(
                    mem[i - 1][j],    # delete
                    mem[i][j - 1],    # insert
                    mem[i - 1][j - 1] # replace
                )
    return mem[m][n]


# -------- Test --------
word1 = "voldemort"
word2 = "dumbledore"

print(minDistanceRecursive(word1, word2))  # Recursive version
print(minDistanceDP(word1, word2))         # DP version
