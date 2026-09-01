"""
Problem: Detect cycle in an undirected graph (BFS)

Idea:
- Use BFS with (node, parent)
- If a visited neighbor is not the parent, cycle exists

Time: O(V + E)
Space: O(V)
"""


from collections import deque


def is_cyclic_bfs(adj):
    n = len(adj)
    visited = [False] * n

    for start in range(n):
        if visited[start]:
            continue

        queue = deque()
        queue.append((start, -1))
        visited[start] = True

        while queue:
            node, parent = queue.popleft()
            for nei in adj[node]:
                if not visited[nei]:
                    visited[nei] = True
                    queue.append((nei, node))
                elif nei != parent:
                    return True
    return False


"""
Problem: Detect cycle in an undirected graph (DFS)

Idea:
- DFS with parent tracking
- If visited neighbor is not parent → cycle

Time: O(V + E)
Space: O(V)
"""


def is_cyclic_dfs(adj):
    n = len(adj)
    visited = [False] * n

    def dfs(node, parent):
        visited[node] = True
        for nei in adj[node]:
            if not visited[nei]:
                if dfs(nei, node):
                    return True
            elif nei != parent:
                return True
        return False

    for i in range(n):
        if not visited[i]:
            if dfs(i, -1):
                return True

    return False


"""
Problem: Detect cycle in an undirected graph (Union Find)

Idea:
- Initially each node is its own parent
- For every edge:
  - If both nodes already have same parent → cycle
  - Else union them

Time: O(V + E)
Space: O(V)
"""


def is_cyclic_union_find(n, edges):
    parent = list(range(n))
    rank = [0] * n

    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    def union(x, y):
        px, py = find(x), find(y)
        if px == py:
            return False
        if rank[px] < rank[py]:
            parent[px] = py
        elif rank[px] > rank[py]:
            parent[py] = px
        else:
            parent[py] = px
            rank[px] += 1
        return True

    for u, v in edges:
        if not union(u, v):
            return True

    return False


# -------------------- TEST --------------------
if __name__ == "__main__":
    # Graph:
    # 0 --- 1
    # |   /
    # |  /
    # 2
    adj = [
        [1, 2],
        [0, 2],
        [0, 1]
    ]

    edges = [(0, 1), (1, 2), (2, 0)]

    print("Cycle (BFS):", is_cyclic_bfs(adj))
    print("Cycle (DFS):", is_cyclic_dfs(adj))
    print("Cycle (Union Find):", is_cyclic_union_find(3, edges))
