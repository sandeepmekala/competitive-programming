# Problem: M-Coloring Problem (Graph Coloring)
# Idea:
# Try to assign one of m colors to each node.
# For every node, try all colors from 1..m.
# A color is valid if none of its adjacent nodes has the same color.
# Use backtracking:
#   - Assign a color
#   - Recurse for next node
#   - Backtrack if it doesn't work
# Time: O(m^n)
# Space: O(n)

def graphColoring(adj, m):
    n = len(adj)
    colors = [0] * n
    return backtrack(adj, 0, colors, m)


def backtrack(adj, node, colors, m):
    if node == len(adj):
        return True

    for col in range(1, m + 1):
        if isSafe(adj, node, colors, col):
            colors[node] = col
            if backtrack(adj, node + 1, colors, m):
                return True
            colors[node] = 0   # backtrack

    return False


def isSafe(adj, node, colors, col):
    for neigh in adj[node]:
        if colors[neigh] == col:
            return False
    return True


# -------- Test --------
adj = [
    [1, 2, 3],
    [0, 2, 3],
    [0, 1],
    [0, 1]
]

m = 3
print(graphColoring(adj, m))
# Expected: True
