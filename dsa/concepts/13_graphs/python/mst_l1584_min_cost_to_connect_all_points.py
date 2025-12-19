import heapq


"""
Problem: https://leetcode.com/problems/min-cost-to-connect-all-points/

Idea:
- Each point is a node
- Graph is fully connected
- Edge weight = Manhattan distance
- Find Minimum Spanning Tree using Prim's Algorithm

Time Complexity:
O(N^2 log N)

Space Complexity:
O(N^2)
"""


def minCostConnectPoints(points):
    n = len(points)

    # Build adjacency list
    adj = [[] for _ in range(n)]
    for i in range(n):
        x1, y1 = points[i]
        for j in range(i + 1, n):
            x2, y2 = points[j]
            dist = abs(x1 - x2) + abs(y1 - y2)
            adj[i].append((j, dist))
            adj[j].append((i, dist))

    return prims_mst(n, adj)


"""
Prim's MST Algorithm
- Always pick the minimum weight edge that connects
  a visited node to an unvisited node
"""
def prims_mst(n, adj):
    min_heap = []
    visited = set()

    # (cost, node)
    heapq.heappush(min_heap, (0, 0))
    total_cost = 0

    while min_heap:
        cost, node = heapq.heappop(min_heap)

        if node in visited:
            continue

        visited.add(node)
        total_cost += cost

        for nei, weight in adj[node]:
            if nei not in visited:
                heapq.heappush(min_heap, (weight, nei))

    return total_cost


# -------------------- TEST --------------------
if __name__ == "__main__":
    points = [
        [0, 0],
        [2, 2],
        [3, 10],
        [5, 2],
        [7, 0]
    ]

    print(minCostConnectPoints(points))
