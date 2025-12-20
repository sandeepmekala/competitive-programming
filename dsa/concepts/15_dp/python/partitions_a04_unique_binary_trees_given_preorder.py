# DP / Catalan Numbers
#
#  0   1   2   3   4   5
#  1   1   2
#
#  n = 2
#  l = 0, r = 1
#  l = 1, r = 0
#
#  n = 3
#  l = 0, r = 2
#  l = 1, r = 1
#  l = 2, r = 0
#
# Problem: Unique Binary Trees Given Preorder
# (Same as counting unique BSTs / Catalan numbers)
#
# Time: O(n^2)
# Space: O(n)

def numTrees(n):
    mem = [0] * (n + 1)
    mem[0] = 1
    mem[1] = 1

    for i in range(2, n + 1):
        for j in range(i):
            mem[i] += mem[j] * mem[i - j - 1]

    return mem[n]


# -------- Test --------
n = 5
print(numTrees(n))  # Expected: 42
