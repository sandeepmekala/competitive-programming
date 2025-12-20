import heapq


def prims_mst(n, adj):
    """
    Problem: Minimum Spanning Tree using Prim's Algorithm

    Idea:
    - Assign edge weight as value to each vertex (distance array concept).
    - Start from any node (0 here) with distance 0.
    - Always pick the vertex with minimum edge weight using a min-heap.
    - If a node is already visited, skip it.
    - Add edge weight to total MST cost when a node is finalized.
    - Push all adjacent edges of the current node into the heap.

    Time Complexity: O(E log E)
    Space Complexity: O(V + E)
    """
    visited = [False] * n
    min_heap = [(0, 0)]  # (edge_weight, node)
    mst_sum = 0

    while min_heap:
        weight, node = heapq.heappop(min_heap)

        if visited[node]:
            continue

        visited[node] = True
        mst_sum += weight

        for neighbor, edge_weight in adj[node]:
            if not visited[neighbor]:
                heapq.heappush(min_heap, (edge_weight, neighbor))

    return mst_sum


if __name__ == "__main__":
    n = 3
    edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]

    adj = [[] for _ in range(n)]
    for u, v, w in edges:
        adj[u].append((v, w))
        adj[v].append((u, w))

    print(prims_mst(n, adj))
