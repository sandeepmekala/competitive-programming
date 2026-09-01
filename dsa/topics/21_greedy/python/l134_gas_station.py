# Greedy
# Problem: https://leetcode.com/problems/gas-station/
# Idea:
# 1. If total gas < total cost, no solution.
# 2. Traverse once and keep accumulating (gas[i] - cost[i]).
# 3. If total becomes negative, reset total and starting index.
# 4. The next index becomes the new candidate start.
# Time: O(n)
# Space: O(1)

def can_complete_circuit(gas, cost):
    total_gas = sum(gas)
    total_cost = sum(cost)

    if total_gas < total_cost:
        return -1

    total = 0
    start = -1

    for i in range(len(gas)):
        total += gas[i] - cost[i]

        if total < 0:
            total = 0
            start = -1
            continue

        if start == -1:
            start = i

    return start


# -------- Test --------
gas  = [1, 2, 3, 4, 5]
cost = [3, 4, 5, 1, 2]
print(can_complete_circuit(gas, cost))  # Expected: 3
