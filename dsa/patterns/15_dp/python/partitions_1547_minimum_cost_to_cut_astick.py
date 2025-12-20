# DP / Partition DP
#
# Problem: https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
# Idea: As we can partition at any index, we apply partition dp technique to run k for all possible partition positions.
# For every cut we need previous upper cut and lower cut. Their difference gives the stick length.
# For left most and right most cuts, there won't be their corresponding lower and high cut values.
# Hence, we insert 0 and stick length as those are treated as initial cuts.

def minCost(n, cuts):
    c = len(cuts)

    # Insert boundary cuts
    cuts_list = cuts[:]
    cuts_list.append(0)
    cuts_list.append(n)
    cuts_list.sort()

    # DP table
    costs = [[0] * (c + 2) for _ in range(c + 2)]

    for i in range(c, 0, -1):
        for j in range(1, c + 1):
            if i > j:
                continue

            minimum = float('inf')
            for k in range(i, j + 1):
                cost = (
                    cuts_list[j + 1] - cuts_list[i - 1]
                    + costs[i][k - 1]
                    + costs[k + 1][j]
                )
                minimum = min(minimum, cost)

            costs[i][j] = minimum

    return costs[1][c]


def minCost2(n, cuts):
    c = len(cuts)

    cuts_temp = [0] * (c + 2)
    cuts_temp[0] = 0
    cuts_temp[c + 1] = n
    for i in range(c):
        cuts_temp[i + 1] = cuts[i]

    cuts_temp.sort()
    return minCost2Helper(1, c, cuts_temp)


def minCost2Helper(i, j, cuts):
    if j < i:
        return 0

    minimum = float('inf')
    for k in range(i, j + 1):
        cost = (
            cuts[j + 1] - cuts[i - 1]
            + minCost2Helper(i, k - 1, cuts)
            + minCost2Helper(k + 1, j, cuts)
        )
        minimum = min(minimum, cost)

    return minimum


# -------- Test --------
n = 7
cuts = [1, 3, 4, 5]

print(minCost(n, cuts))   # Expected: 16
print(minCost2(n, cuts))  # Expected: 16
