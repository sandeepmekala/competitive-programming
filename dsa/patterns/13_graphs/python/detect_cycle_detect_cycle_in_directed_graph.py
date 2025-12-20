"""
Problem: Detect cycle in a directed graph

Idea (DFS):
- Maintain two arrays:
  1. visited[] → node is visited at least once
  2. path_visited[] → node is in current DFS path
- If during DFS we reach a node already in path_visited,
  then a cycle exists.

Time Complexity: O(V + E)
Space Complexity: O(V)
"""


def is_cyclic_dfs(adj):
    n = len(adj)
    visited = [False] * n
    path_visited = [False] * n

    def dfs(node):
        visited[node] = True
        path_visited[node] = True

        for nei in adj[node]:
            if not visited[nei]:
                if dfs(nei):
                    return True
            elif path_visited[nei]:
                return True

        path_visited[node] = False
        return False

    for node in range(n):
        if not visited[node]:
            if dfs(node):
                return True

    return False


"""
Idea (BFS – Kahn’s Algorithm):
- Compute indegree of all nodes
- Push nodes with indegree 0 into queue
- Perform topological sort
- If topo count != number of nodes, cycle exists

Time Complexity: O(V + E)
Space Complexity: O(V)
"""


def is_cyclic_bfs(n, adj):
    indegree = [0] * n

    for node in range(n):
        for nei in adj[node]:
            indegree[nei] += 1

    queue = []
    for node in range(n):
        if indegree[node] == 0:
            queue.append(node)

    count = 0
    while queue:
        node = queue.pop(0)
        count += 1
        for nei in adj[node]:
            indegree[nei] -= 1
            if indegree[nei] == 0:
                queue.append(nei)

    return count != n


# -------------------- TEST --------------------
if __name__ == "__main__":
    adj = [[] for _ in range(4)]
    adj[0].extend([1, 2])
    adj[1].append(2)
    adj[2].extend([0, 3])

    print("Is cyclic (DFS):", is_cyclic_dfs(adj))
    print("Is cyclic (BFS):", is_cyclic_bfs(4, adj))
