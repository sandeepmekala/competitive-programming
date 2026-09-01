"""
Maximum Flow using Ford–Fulkerson Algorithm
(Edmonds–Karp implementation using BFS)

- Uses adjacency matrix for capacity
- BFS is used to find augmenting paths
- Updates residual graph after every augmentation

Time Complexity:
O(V * E^2)

Space Complexity:
O(V^2)
"""


from collections import deque


def max_flow(capacity, src, sink):
    """
    Finds the maximum flow from src to sink
    """
    n = len(capacity)
    total_max_flow = 0
    parent = [-1] * n

    while bfs(capacity, src, sink, parent):
        curr_flow = augment_path(capacity, src, sink, parent)
        total_max_flow += curr_flow
        parent = [-1] * n

    return total_max_flow


def bfs(capacity, src, sink, parent):
    """
    BFS to find an augmenting path
    """
    n = len(capacity)
    visited = [False] * n
    q = deque()

    q.append(src)
    visited[src] = True

    while q:
        node = q.popleft()

        if node == sink:
            return True

        for nei in range(n):
            if capacity[node][nei] > 0 and not visited[nei]:
                visited[nei] = True
                parent[nei] = node
                q.append(nei)

    return False


def augment_path(capacity, src, sink, parent):
    """
    Finds minimum flow in the augmenting path
    and updates residual graph
    """
    curr = sink
    min_flow = float("inf")

    # Find minimum capacity in the path
    while curr != src:
        prev = parent[curr]
        min_flow = min(min_flow, capacity[prev][curr])
        curr = prev

    # Update residual capacities
    curr = sink
    while curr != src:
        prev = parent[curr]
        capacity[prev][curr] -= min_flow
        capacity[curr][prev] += min_flow
        curr = prev

    return min_flow


# -------------------- TEST --------------------
if __name__ == "__main__":
    capacity = [
        [0, 3, 0, 3, 0, 0, 0],
        [0, 0, 4, 0, 0, 0, 0],
        [3, 0, 0, 1, 2, 0, 0],
        [0, 0, 0, 0, 2, 6, 0],
        [0, 1, 0, 0, 0, 0, 1],
        [0, 0, 0, 0, 0, 0, 9],
        [0, 0, 0, 0, 0, 0, 0],
    ]

    print("Maximum Flow:", max_flow(capacity, 0, 6))
