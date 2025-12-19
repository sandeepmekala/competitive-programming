"""
Problem:
Find the size of the largest connected component in an undirected graph.

Idea:
- Traverse all nodes
- For each unvisited node, run DFS to calculate component size
- Track the maximum size

Time: O(V + E)
Space: O(V)
"""


def largest_connected_components(adj):
    visited = set()
    max_size = 0

    for src in range(len(adj)):
        size = dfs(adj, src, visited)
        max_size = max(max_size, size)

    return max_size


"""
DFS to count size of connected component
"""


def dfs(adj, src, visited):
    if src in visited:
        return 0

    visited.add(src)
    count = 1

    for child in adj[src]:
        count += dfs(adj, child, visited)

    return count


# -------------------- TEST --------------------
if __name__ == "__main__":
    adj = [[] for _ in range(9)]

    adj[1].append(2)
    adj[2].append(1)

    adj[4].append(6)
    adj[6].append(4)

    adj[5].append(6)
    adj[6].append(5)

    adj[7].append(6)
    adj[6].append(7)

    adj[8].append(6)
    adj[6].append(8)

    adj[3].append(3)   # self-loop

    print(largest_connected_components(adj))
