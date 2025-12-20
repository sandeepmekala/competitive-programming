# DP / Partition DP
#
# Problem: Build bst in such a way that total search cost should be minimal.
# Root cost will be multiple of level in bottom up order.
#
# Idea:
#
# i\j   10   12   16   21
# 10     4    8   20   26
# 12          2   10   16
# 16               6   12
# 21                    3
#
# Time: O(n^3)
# Space: O(n^2)

def optimalCost(items, costs, n):
    mem = [[0] * n for _ in range(n)]

    for l in range(n):                      # length of interval
        for i in range(n - l):
            j = i + l

            if i == j:
                mem[i][j] = costs[i]
                continue

            # sum of costs from i to j
            total = 0
            for k in range(i, j + 1):
                total += costs[k]

            minimum = float('inf')
            for k in range(i, j + 1):       # every k between i and j becomes root
                temp = 0
                if k - 1 >= i:
                    temp += mem[i][k - 1]
                if k + 1 <= j:
                    temp += mem[k + 1][j]

                minimum = min(minimum, temp)

            mem[i][j] = total + minimum

    return mem[0][n - 1]


# -------- Test --------
items = [10, 12, 16, 21]
costs = [4, 2, 6, 3]
n = len(items)

print(optimalCost(items, costs, n))  # Expected: 26
