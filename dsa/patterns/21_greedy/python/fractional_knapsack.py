# Problem: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
# Idea: Greedy
# Sort items based on value/weight ratio (descending).
# Pick items greedily until capacity is full.
# If item doesn't fit completely, take fractional part.
# Time: O(n log n)
# Space: O(1)

def fractional_knapsack(capacity, items):
    # items -> list of (value, weight)

    # sort by value/weight ratio
    items.sort(key=lambda x: x[0] / x[1], reverse=True)

    total_value = 0.0
    for value, weight in items:
        if weight <= capacity:
            capacity -= weight
            total_value += value
        else:
            total_value += (value / weight) * capacity
            break

    return total_value


# -------- Test --------
items = [
    (100, 20),
    (60, 10),
    (120, 30)
]
capacity = 50

print(fractional_knapsack(capacity, items))
