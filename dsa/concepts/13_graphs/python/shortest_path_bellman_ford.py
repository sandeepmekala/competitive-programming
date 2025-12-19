from typing import List


class Edge:
    def __init__(self, src: int, dest: int, weight: int):
        self.src = src
        self.dest = dest
        self.weight = weight


"""
Idea: Loop n-1 times and relax all edges. In worst case the graph
can be linear and in each iteration we might relax only one edge. Hence, n-1
times relaxation needed.
Works with negative edges also unlike Dijkstra.
With one more additional iteration can detect negative weight cycle. You will
see dist array getting updated.
Time = O(V*E)
Space = O(V)
"""
def shortest_path(n: int, edges: List[Edge], src: int) -> List[int]:
    INF = float("inf")
    dist = [INF] * n
    parent = list(range(n))

    dist[src] = 0

    # relax edges n-1 times
    for _ in range(n - 1):
        for edge in edges:
            u, v, w = edge.src, edge.dest, edge.weight
            if dist[u] == INF:
                continue

            if dist[u] + w < dist[v]:
                dist[v] = dist[u] + w
                parent[v] = u

    return dist


# one test (same as Java main)
if __name__ == "__main__":
    n = 5
    edges = [
        Edge(4, 3, 1),
        Edge(0, 1, 4),
        Edge(0, 2, 5),
        Edge(0, 3, 8),
        Edge(1, 2, -3),
        Edge(2, 4, 4),
        Edge(3, 4, 2),
    ]

    print(shortest_path(n, edges, 0))
