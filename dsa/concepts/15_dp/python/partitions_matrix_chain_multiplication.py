# DP / Partition DP
#
# Problem: Minimum operations to multiply given matrices
# Idea: Similar like palindrome partitioning.
# Check the cost for every position from i to j and take the min.
#
#           (1,2),   (2,3),   (3,4),   (4,3)
# i\j   0   1       2       3       4
#       0   0       0       0       0
#       1           0       6       18      30
#       2                   0       24      72
#       3                           0       36
#       4                                   0
#
# Time: O(n^3)
# Similar problem DP 52. Evaluate Boolean Expression to True


def operations(dim):
    n = len(dim)
    ops = [[0] * n for _ in range(n)]

    for i in range(n - 1, 0, -1):
        for j in range(n):
            if i >= j:
                continue      # As i should be less than j

            ops[i][j] = float('inf')
            for k in range(i, j):
                cnt = (
                    ops[i][k]
                    + ops[k + 1][j]
                    + dim[i - 1] * dim[k] * dim[j]
                )
                if cnt < ops[i][j]:
                    ops[i][j] = cnt

    return ops[1][n - 1]


# O(n^3) recursive solution
def operations2(dim, i, j):
    if i == j:
        return 0

    minimum = float('inf')
    for k in range(i, j):
        cnt = (
            operations2(dim, i, k)
            + operations2(dim, k + 1, j)
            + dim[i - 1] * dim[k] * dim[j]
        )
        if cnt < minimum:
            minimum = cnt

    return minimum


# Alternative way to solve the problem
# l keeps the length of the chain
def operations3(dimensions):
    n = len(dimensions)
    ops = [[0] * n for _ in range(n)]

    for l in range(1, n):
        for i in range(1, n - l):
            j = i + l
            ops[i][j] = float('inf')

            for k in range(i, j):
                count = (
                    ops[i][k]
                    + ops[k + 1][j]
                    + dimensions[i - 1] * dimensions[k] * dimensions[j]
                )
                if count < ops[i][j]:
                    ops[i][j] = count

    return ops[1][n - 1]


# -------- Test --------
dimensions = [1, 2, 3, 4, 3]   # (1,2), (2,3), (3,4), (4,3)
n = len(dimensions)

print(operations(dimensions))                 # Expected: 30
print(operations2(dimensions, 1, n - 1))      # Expected: 30
print(operations3(dimensions))                # Expected: 30
