"""
Problem: https://leetcode.com/problems/critical-connections-in-a-network/
Idea:
- Use Tarjan's algorithm to find bridges
- Track insertion time (tin) and low time (low) of each node
- low[v] = lowest insertion time reachable from v (excluding parent edge)
- If low[nei] > tin[node], then edge (node, nei) is a bridge
- Parent edge is ignored because we assume it is removed
Time Complexity: O(V + E)
Space Complexity: O(V + E)
"""


def critical_connections(n, connections):
    # build adjacency list
    adj = [[] for _ in range(n)]
    for u, v in connections:
        adj[u].append(v)
        adj[v].append(u)

    visited = [False] * n
    tin = [-1] * n
    low = [-1] * n
    bridges = []

    timer = 0

    def dfs(node, parent):
        nonlocal timer
        visited[node] = True
        tin[node] = low[node] = timer
        timer += 1

        for nei in adj[node]:
            if nei == parent:
                continue

            if not visited[nei]:
                dfs(nei, node)
                low[node] = min(low[node], low[nei])

                # node -- nei is a bridge
                if low[nei] > tin[node]:
                    bridges.append([node, nei])
            else:
                low[node] = min(low[node], tin[nei])

    # graph may not be connected
    for i in range(n):
        if not visited[i]:
            dfs(i, -1)

    return bridges


# -------------------- TEST --------------------
if __name__ == "__main__":
    n = 4
    connections = [
        [0, 1],
        [1, 2],
        [2, 0],
        [1, 3]
    ]

    result = critical_connections(n, connections)
    for bridge in result:
        print(bridge)
