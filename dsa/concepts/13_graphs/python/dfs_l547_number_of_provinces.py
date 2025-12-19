"""
Problem:
https://leetcode.com/problems/number-of-provinces/

Idea:
- Given adjacency matrix of cities
- Convert adjacency matrix to adjacency list
- Use DFS to find connected components
- Each DFS call gives one province

Time: O(n^2)
Space: O(n^2)
"""


def find_circle_num(is_connected):
    n = len(is_connected)

    # Convert adjacency matrix to adjacency list
    adj = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if is_connected[i][j] == 1 and i != j:
                adj[i].append(j)
                adj[j].append(i)

    visited = [False] * n
    count = 0

    for i in range(n):
        if not visited[i]:
            dfs(i, adj, visited)
            count += 1

    return count


"""
DFS to mark all connected cities in a province
"""


def dfs(node, adj, visited):
    visited[node] = True
    for nei in adj[node]:
        if not visited[nei]:
            dfs(nei, adj, visited)


# -------------------- TEST --------------------
if __name__ == "__main__":
    is_connected = [
        [1, 1, 0],
        [1, 1, 0],
        [0, 0, 1]
    ]

    print(find_circle_num(is_connected))
