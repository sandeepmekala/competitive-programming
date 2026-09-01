from collections import defaultdict
import math


"""
Problem: https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph

Idea:
Since the graph is a DAG, we can compute the shortest path using
Topological Sorting.

Steps:
1. Build adjacency list.
2. Perform topological sort using DFS.
3. Initialize distance array.
4. Relax edges in topological order.

Time Complexity: O(V + E)
Space Complexity: O(V + E)
"""
def shortest_path_dag(N, edges):
    # build adjacency list
    adj = [[] for _ in range(N)]
    for u, v, w in edges:
        adj[u].append((v, w))

    visited = [False] * N
    stack = []

    def topo_sort(node):
        visited[node] = True
        for neigh, _ in adj[node]:
            if not visited[neigh]:
                topo_sort(neigh)
        stack.append(node)

    # topo sort for all components
    for i in range(N):
        if not visited[i]:
            topo_sort(i)

    # shortest path relaxation
    dist = [math.inf] * N
    dist[0] = 0

    while stack:
        node = stack.pop()
        if dist[node] == math.inf:
            continue

        for neigh, weight in adj[node]:
            if dist[node] + weight < dist[neigh]:
                dist[neigh] = dist[node] + weight

    return dist


# one test (same as Java main)
if __name__ == "__main__":
    edges = [
        [0, 1, 2],
        [0, 4, 1],
        [4, 5, 4],
        [4, 2, 2],
        [1, 2, 3],
        [2, 3, 6],
        [5, 3, 1]
    ]

    result = shortest_path_dag(6, edges)
    print(result)
