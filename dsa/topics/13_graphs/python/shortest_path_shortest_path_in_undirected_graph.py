from collections import deque
import math


"""
Idea:
Since the graph is undirected and all edges have unit weight,
the shortest path can be found using BFS.

Approach:
1. Use BFS starting from source.
2. Each BFS level represents distance +1.
3. First time reaching a node guarantees the shortest distance.

Time Complexity: O(V + E)
Space Complexity: O(V)
"""
def shortest_path_to_dest(adj, src, dest):
    n = len(adj)
    visited = [False] * n
    q = deque()

    q.append((src, 0))
    visited[src] = True

    while q:
        node, dist = q.popleft()
        if node == dest:
            return dist

        for neigh in adj[node]:
            if not visited[neigh]:
                visited[neigh] = True
                q.append((neigh, dist + 1))

    return -1


"""
Problem:
https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/

Idea:
Compute shortest distance from source to ALL nodes using BFS.
Distance relaxations are always +1 since unit edges.

Time Complexity: O(V + E)
Space Complexity: O(V)
"""
def shortest_path_all(adj, src):
    n = len(adj)
    dist = [math.inf] * n
    q = deque()

    dist[src] = 0
    q.append(src)

    while q:
        node = q.popleft()
        for neigh in adj[node]:
            if dist[node] + 1 < dist[neigh]:
                dist[neigh] = dist[node] + 1
                q.append(neigh)

    return dist


# one test (same as Java main)
if __name__ == "__main__":
    adj = [[] for _ in range(5)]

    adj[0].append(1)
    adj[0].append(2)
    adj[1].append(3)
    adj[3].append(0)
    adj[3].append(4)

    print(shortest_path_to_dest(adj, 0, 4))
    print(shortest_path_all(adj, 0))
