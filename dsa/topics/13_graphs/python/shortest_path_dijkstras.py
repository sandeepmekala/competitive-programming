import heapq
from typing import List


"""
Idea: Same as Prim's algorithm except that instead of just checking the edge
weight, we track cumulative distance from the source.
Use dist array to track distance of each vertex.
Parent array can be used if path reconstruction is needed.
Drawbacks: Won't work with negative edge weights. Use Bellman-Ford instead.
Time Complexity: O(E log V)
"""
def dijkstra(adj: List[List[List[int]]], src: int) -> List[int]:
    n = len(adj)
    INF = float("inf")

    dist = [INF] * n
    dist[src] = 0

    pq = []
    heapq.heappush(pq, (0, src))   # (distance, node)

    while pq:
        curr_dist, node = heapq.heappop(pq)

        for nei_node, weight in adj[node]:
            if curr_dist + weight < dist[nei_node]:
                dist[nei_node] = curr_dist + weight
                heapq.heappush(pq, (dist[nei_node], nei_node))

    return dist


# one test (same as Java main)
if __name__ == "__main__":
    adj = [
        [[1, 1], [2, 6]],
        [[2, 3], [0, 1]],
        [[1, 3], [0, 6]]
    ]

    print(dijkstra(adj, 2))
