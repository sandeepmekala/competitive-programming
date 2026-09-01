import heapq
import math


"""
Problem: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

Idea:
Apply Dijkstra’s algorithm while also tracking the number of shortest paths
to each node.

Rules:
1. If a shorter distance is found for a node, replace its distance and copy
   the number of ways from the parent.
2. If the same shortest distance is found again via another route, add the
   number of ways from the parent.
3. Use modulo (1e9 + 7) for large counts.

Time Complexity: O(E log V)
Space Complexity: O(V + E)
"""
def count_paths(n, roads):
    MOD = 10**9 + 7

    # build adjacency list
    adj = [[] for _ in range(n)]
    for u, v, w in roads:
        adj[u].append((v, w))
        adj[v].append((u, w))

    dist = [math.inf] * n
    ways = [0] * n

    dist[0] = 0
    ways[0] = 1

    pq = []
    heapq.heappush(pq, (0, 0))   # (distance, node)

    while pq:
        curr_dist, node = heapq.heappop(pq)

        if curr_dist > dist[node]:
            continue

        for neigh, weight in adj[node]:
            new_dist = curr_dist + weight

            # first time reaching with shorter distance
            if new_dist < dist[neigh]:
                dist[neigh] = new_dist
                ways[neigh] = ways[node]
                heapq.heappush(pq, (new_dist, neigh))

            # reaching again with same shortest distance
            elif new_dist == dist[neigh]:
                ways[neigh] = (ways[neigh] + ways[node]) % MOD

    return ways[n - 1] % MOD


# one test (same as Java main)
if __name__ == "__main__":
    roads = [
        [0, 6, 7],
        [0, 1, 2],
        [1, 2, 3],
        [1, 3, 3],
        [6, 3, 3],
        [3, 5, 1],
        [6, 5, 1],
        [2, 5, 1],
        [0, 4, 5],
        [4, 6, 2]
    ]
    print(count_paths(7, roads))  # expected: 4
