"""
Problem: https://leetcode.ca/2020-11-23-1820-Maximum-Number-of-Accepted-Invitations/
Idea:
- Treat rows as left set and columns as right set of a bipartite graph
- grid[i][j] == 1 means edge between i (left) and j (right)
- Use DFS-based bipartite matching (Kuhn’s algorithm)
Time Complexity: O(m * n)
Space Complexity: O(n)
"""


def maximum_invitations(grid):
    m, n = len(grid), len(grid[0])
    match = [-1] * n
    ans = 0

    def dfs(i, visited):
        for j in range(n):
            if grid[i][j] == 1 and not visited[j]:
                visited[j] = True
                if match[j] == -1 or dfs(match[j], visited):
                    match[j] = i
                    return True
        return False

    for i in range(m):
        visited = [False] * n
        if dfs(i, visited):
            ans += 1

    return ans


# -------------------- TEST --------------------
if __name__ == "__main__":
    grid = [
        [1, 1, 1],
        [1, 0, 1],
        [0, 0, 1]
    ]

    print(maximum_invitations(grid))  # Output: 3
