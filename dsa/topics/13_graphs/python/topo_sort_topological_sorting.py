from collections import deque
from typing import List


"""
Problem:
Topological Sorting of a Directed Acyclic Graph (DAG)

Idea (DFS based):
In a DAG, for every directed edge (u -> v), u must appear before v.
We perform DFS and push the node into a stack *after* visiting all neighbors.
Finally, reversing the stack gives topological order.

Time:  O(V + E)
Space: O(V)
"""
def topo_sort_by_dfs(adj: List[List[int]]) -> List[int]:
    n = len(adj)
    visited = [False] * n
    stack = []

    def dfs(node: int) -> None:
        visited[node] = True
        for nei in adj[node]:
            if not visited[nei]:
                dfs(nei)
        stack.append(node)

    for i in range(n):
        if not visited[i]:
            dfs(i)

    return stack[::-1]   # reverse to get topo order


"""
Problem:
Topological Sorting using Kahn's Algorithm (BFS)

Idea:
1. Compute indegree of all nodes
2. Push all nodes with indegree 0 into queue
3. Pop node, add to topo list, reduce indegree of neighbors
4. If indegree becomes 0, push neighbor into queue

Time:  O(V + E)
Space: O(V)
"""
def topo_sort_by_kahns_algo(n: int, adj: List[List[int]]) -> List[int]:
    indegree = [0] * n

    for u in range(n):
        for v in adj[u]:
            indegree[v] += 1

    q = deque()
    for i in range(n):
        if indegree[i] == 0:
            q.append(i)

    topo = []
    while q:
        node = q.popleft()
        topo.append(node)
        for nei in adj[node]:
            indegree[nei] -= 1
            if indegree[nei] == 0:
                q.append(nei)

    return topo


# ----------- test (same as Java main) -----------
if __name__ == "__main__":
    adj = [[] for _ in range(6)]
    adj[5].extend([2, 0])
    adj[4].extend([0, 1])
    adj[2].append(3)
    adj[3].append(1)

    print("DFS Topo Sort:", topo_sort_by_dfs(adj))
    print("Kahn's Topo Sort:", topo_sort_by_kahns_algo(6, adj))
