from typing import List
from collections import defaultdict
import heapq


"""
Problem: https://leetcode.com/problems/network-delay-time/
Idea:
We need to find the shortest time to reach every node from source k.
This is a standard Dijkstra problem.
The answer is the maximum distance among all reachable nodes.
If any node is unreachable, return -1.

Time Complexity: O(E log V)
Space Complexity: O(V + E)
"""
def network_delay_time(times: List[List[int]], n: int, k: int) -> int:
    adj = defaultdict(list)
    for src, dest, time in times:
        adj[src].append((time, dest))

    dist = [float('inf')] * (n + 1)
    dist[k] = 0

    visited = set()
    pq = []
    heapq.heappush(pq, (0, k))   # (time, node)

    max_time = 0

    while pq:
        time, node = heapq.heappop(pq)

        if node in visited:
            continue

        visited.add(node)
        max_time = max(max_time, time)

        for edge_time, nei in adj[node]:
            if nei not in visited and time + edge_time < dist[nei]:
                dist[nei] = time + edge_time
                heapq.heappush(pq, (dist[nei], nei))

    return max_time if len(visited) == n else -1


# one test (same as Java main)
if __name__ == "__main__":
    times = [
        [2, 1, 1],
        [2, 3, 1],
        [3, 4, 1]
    ]
    print(network_delay_time(times, 4, 2))  # 2
