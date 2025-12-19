"""
Problem: Articulation Point in an Undirected Graph

Idea:
- Use DFS with discovery time (tin) and low-link values (low)
- A node is an articulation point if:
  1) It is NOT root and low[child] >= tin[node]
  2) It IS root and has more than one DFS child
- Use tin instead of low for visited neighbors to ensure correct back-edge handling
- Same node can be detected multiple times → store in a set

Time: O(V + E)
"""

def articulation_points(n, adj):
    vis = [0] * n
    tin = [0] * n
    low = [0] * n
    timer = [1]                 # mutable timer
    art_points = set()

    for i in range(n):
        if not vis[i]:
            dfs(i, -1, vis, tin, low, timer, art_points, adj)

    return list(art_points) if art_points else [-1]


def dfs(node, parent, vis, tin, low, timer, art_points, adj):
    vis[node] = 1
    tin[node] = low[node] = timer[0]
    timer[0] += 1

    children = 0

    for nei in adj[node]:
        if nei == parent:
            continue

        if not vis[nei]:
            dfs(nei, node, vis, tin, low, timer, art_points, adj)
            low[node] = min(low[node], low[nei])

            # Non-root articulation point condition
            if low[nei] >= tin[node] and parent != -1:
                art_points.add(node)

            children += 1
        else:
            # Back-edge case
            low[node] = min(low[node], tin[nei])

    # Root articulation point condition
    if parent == -1 and children > 1:
        art_points.add(node)


if __name__ == "__main__":
    n = 5
    edges = [
        (0, 1), (1, 4),
        (2, 4), (2, 3), (3, 4)
    ]

    adj = [[] for _ in range(n)]
    for u, v in edges:
        adj[u].append(v)
        adj[v].append(u)

    print(articulation_points(n, adj))
