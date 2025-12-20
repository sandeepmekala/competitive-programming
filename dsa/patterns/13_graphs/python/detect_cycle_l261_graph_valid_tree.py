"""
Problem: https://leetcode.ca/2016-08-17-261-Graph-Valid-Tree/

Idea:
- A graph is a valid tree if:
  1) It has no cycle
  2) It is fully connected

Approach:
- Build an undirected adjacency list
- Run DFS to detect cycle
- Track visited nodes
- Ensure all nodes are visited (connected)

Time: O(V + E)
Space: O(V + E)
"""


def valid_tree(n, edges):
    if n == 0:
        return True

    # Build adjacency list
    adj = [[] for _ in range(n)]
    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)

    visited = set()

    # DFS from node 0
    if not dfs(0, -1, adj, visited):
        return False

    # Ensure graph is connected
    return len(visited) == n


"""
DFS helper for cycle detection in undirected graph
"""


def dfs(curr, parent, adj, visited):
    visited.add(curr)

    for nei in adj[curr]:
        if nei not in visited:
            if not dfs(nei, curr, adj, visited):
                return False
        elif nei != parent:
            # Found a back-edge -> cycle
            return False

    return True


# -------------------- TEST --------------------
if __name__ == "__main__":
    n = 5

    # edges = [[0, 1], [0, 2], [0, 3], [1, 4]]       # True
    edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]] # False (cycle)

    print(valid_tree(n, edges))
