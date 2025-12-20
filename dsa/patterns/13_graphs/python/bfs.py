from collections import deque

"""
Idea:
- Standard BFS traversal using a queue
- Start from source node
- Mark nodes visited to avoid revisiting
Time: O(V + E)
Space: O(V)
"""


def bfs(adj, src):
    n = len(adj)
    visited = [False] * n
    result = []

    q = deque([src])
    visited[src] = True

    while q:
        curr = q.popleft()
        result.append(curr)

        for nei in adj[curr]:
            if not visited[nei]:
                visited[nei] = True
                q.append(nei)

    return result


# -------------------- TEST --------------------
if __name__ == "__main__":
    adj = [[] for _ in range(4)]

    adj[0].extend([1, 2])
    adj[1].append(2)
    adj[2].extend([0, 3])
    adj[3].append(3)

    print(bfs(adj, 0))   # [0, 1, 2, 3]
