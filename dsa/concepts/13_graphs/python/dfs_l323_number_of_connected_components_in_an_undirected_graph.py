"""
Problem:
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

Idea:
- Build adjacency list from edges
- Traverse all nodes
- If a node is not visited, run DFS from it
- Each DFS traversal represents one connected component

Time: O(V + E)
Space: O(V + E)
"""


def count_components(n, edges):
    adj = [[] for _ in range(n)]
    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)

    vis = [0] * n
    count = 0

    for i in range(n):
        if vis[i] == 0:
            dfs(adj, i, vis)
            count += 1

    return count


"""
DFS to explore all nodes in the same connected component
"""


def dfs(adj, src, vis):
    vis[src] = 1
    for nei in adj[src]:
        if vis[nei] == 0:
            dfs(adj, nei, vis)


# -------------------- TEST --------------------
if __name__ == "__main__":
    n = 5
    edges = [[0, 1], [1, 2], [3, 4]]

    print(count_components(n, edges))  # Output: 2
