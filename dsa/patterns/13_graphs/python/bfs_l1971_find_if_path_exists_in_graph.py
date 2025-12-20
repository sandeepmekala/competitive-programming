from collections import deque

"""
Problem: https://leetcode.com/problems/find-if-path-exists-in-graph/
Idea:
- Use BFS starting from source
- Track visited nodes to avoid cycles
- Graph is undirected
- If destination is reached, return True
Time: O(V + E)
"""


def validPath(n, edges, src, dest):
    if src == dest:
        return True

    # Build adjacency list
    adj = [[] for _ in range(n)]
    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)

    visited = set()
    q = deque([src])
    visited.add(src)

    while q:
        curr = q.popleft()
        if curr == dest:
            return True

        for nei in adj[curr]:
            if nei not in visited:
                visited.add(nei)
                q.append(nei)

    return False


# -------------------- TEST --------------------
if __name__ == "__main__":
    n = 3
    edges = [[0, 1], [1, 2], [2, 0]]
    print(validPath(n, edges, 0, 2))   # True
