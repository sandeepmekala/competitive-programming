from collections import deque

"""
Problem: https://leetcode.com/problems/is-graph-bipartite/
Idea:
- Use BFS or DFS
- Assign colors (0 / 1) to nodes
- Neighbors must always have opposite colors
- If a neighbor already has the same color → not bipartite
- Graph may be disconnected, so check every node
Time: O(V + E)
"""


def isBipartite(graph):
    n = len(graph)
    colors = [-1] * n   # -1 means uncolored

    for src in range(n):
        if colors[src] == -1:
            if not bfs(graph, src, colors):
                return False
    return True


def bfs(graph, src, colors):
    q = deque()
    q.append(src)
    colors[src] = 1

    while q:
        node = q.popleft()
        for nei in graph[node]:
            if colors[nei] == -1:
                colors[nei] = 1 - colors[node]
                q.append(nei)
            elif colors[nei] == colors[node]:
                return False

    return True


def isBipartiteDfs(graph):
    n = len(graph)
    colors = [-1] * n

    for src in range(n):
        if colors[src] == -1:
            if not dfs(graph, src, 0, colors):
                return False
    return True


def dfs(graph, node, color, colors):
    colors[node] = color

    for nei in graph[node]:
        if colors[nei] == -1:
            if not dfs(graph, nei, 1 - color, colors):
                return False
        elif colors[nei] == colors[node]:
            return False

    return True


# -------------------- TEST --------------------
if __name__ == "__main__":
    graph1 = [[1, 2, 3], [0, 2], [0, 1, 3], [0, 2]]
    graph2 = [[1, 3], [0, 2], [1, 3], [0, 2]]

    print(isBipartite(graph1))      # False
    print(isBipartite(graph2))      # True
    print(isBipartiteDfs(graph2))   # True
