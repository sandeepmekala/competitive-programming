from typing import List
from collections import defaultdict, deque
import math


"""
Problem: https://leetcode.com/problems/cheapest-flights-within-k-stops/
Idea:
The idea of running it for only k steps is hard to be implemented in Dijkstra.
It is easy to be implemented using Bellman Ford as Bellman Ford runs for n-1 steps.

We run Bellman Ford layer by layer by relaxing all edges for k+1 times.
There will be k+1 edges between source and destination for k stops.

Time Complexity: O(k * E)
Space Complexity: O(V)
"""
def find_cheapest_price(n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
    INF = math.inf
    dist = [INF] * n
    dist[src] = 0

    # relax edges k+1 times
    for _ in range(k + 1):
        temp = dist[:]
        for u, v, w in flights:
            if dist[u] == INF:
                continue
            if dist[u] + w < temp[v]:
                temp[v] = dist[u] + w
        dist = temp

    return -1 if dist[dst] == INF else dist[dst]


"""
Problem: https://leetcode.com/problems/cheapest-flights-within-k-stops/
Idea:
The same problem can be solved using BFS / Dijkstra style traversal
by prioritizing number of stops instead of distance.

We perform level-wise traversal (like BFS) while tracking cost.
Only paths with stops <= k are allowed.

Time Complexity: O(E * k)
Space Complexity: O(V)
"""
def cheapest_flight(n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
    adj = defaultdict(list)
    for u, v, w in flights:
        adj[u].append((v, w))

    q = deque()
    q.append((0, src, 0))   # (stops, node, cost)

    dist = [math.inf] * n
    dist[src] = 0

    while q:
        stops, node, cost = q.popleft()

        if stops > k:
            continue

        for neigh, edge_cost in adj[node]:
            if cost + edge_cost < dist[neigh]:
                dist[neigh] = cost + edge_cost
                q.append((stops + 1, neigh, cost + edge_cost))

    return -1 if dist[dst] == math.inf else dist[dst]


# one test (same as Java main)
if __name__ == "__main__":
    n = 4
    flights = [
        [0, 1, 100],
        [1, 2, 100],
        [2, 0, 100],
        [1, 3, 600],
        [2, 3, 200]
    ]
    src = 0
    dst = 3
    k = 1

    print(find_cheapest_price(n, flights, src, dst, k))   # 700
    print(cheapest_flight(n, flights, src, dst, k))       # 700
