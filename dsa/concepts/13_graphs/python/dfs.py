"""
Depth First Search (DFS)

- Graph is represented using adjacency list
- Supports:
  1) Recursive DFS
  2) Iterative DFS using stack

Time Complexity: O(V + E)
Space Complexity: O(V)
"""


def dfs_recursive(adj, src):
    """
    Recursive DFS
    """
    n = len(adj)
    visited = [0] * n
    result = []

    _dfs(adj, src, visited, result)
    return result


def _dfs(adj, node, visited, result):
    visited[node] = 1
    result.append(node)

    for nei in adj[node]:
        if visited[nei] == 0:
            _dfs(adj, nei, visited, result)


def dfs_iterative(adj, src):
    """
    Iterative DFS using stack
    """
    n = len(adj)
    visited = [0] * n
    result = []

    stack = []
    stack.append(src)
    visited[src] = 1

    while stack:
        node = stack.pop()
        result.append(node)

        for nei in adj[node]:
            if visited[nei] == 0:
                visited[nei] = 1
                stack.append(nei)

    return result


# -------------------- TEST --------------------
if __name__ == "__main__":
    adj = [[] for _ in range(4)]

    adj[0].append(1)
    adj[0].append(2)
    adj[1].append(2)
    adj[2].append(0)
    adj[2].append(3)
    adj[3].append(3)

    print("Iterative DFS:", dfs_iterative(adj, 0))
    print("Recursive DFS:", dfs_recursive(adj, 0))
