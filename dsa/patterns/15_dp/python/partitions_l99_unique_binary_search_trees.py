# DP / Catalan Numbers
#
# Problem: Unique Binary Search Trees
# (LeetCode 96)
#
# Idea:
# Number of unique BSTs with n nodes follows Catalan numbers.
# For every node chosen as root, left subtree has j nodes
# and right subtree has (n - j - 1) nodes.
#
# mem[n] = Σ mem[j] * mem[n - j - 1]
#
# Time: O(n^2)
# Space: O(n)

def numTrees(n):
    mem = [0] * (n + 1)
    mem[0] = 1
    mem[1] = 1

    for i in range(2, n + 1):
        for j in range(i):
            # -1 is to exclude the root
            mem[i] += mem[j] * mem[i - j - 1]

    return mem[n]


# -------- Test --------
n = 5
print(numTrees(n))  # Expected: 42
