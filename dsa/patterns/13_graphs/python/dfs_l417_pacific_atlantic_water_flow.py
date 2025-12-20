"""
Problem:
https://leetcode.com/problems/pacific-atlantic-water-flow/

Idea:
- Water can flow from a cell to another if the next cell height >= current cell
- Instead of starting DFS from every cell, start DFS from the oceans
- Pacific touches top row & left column
- Atlantic touches bottom row & right column
- Mark all cells reachable from Pacific and Atlantic separately
- Intersection of both visited sets gives the answer

Time: O(m * n)
Space: O(m * n)
"""


def pacific_atlantic(heights):
    if not heights or not heights[0]:
        return []

    m, n = len(heights), len(heights[0])

    pacific = [[False] * n for _ in range(m)]
    atlantic = [[False] * n for _ in range(m)]

    # DFS from Pacific borders (top row & left column)
    for i in range(m):
        dfs(heights, i, 0, pacific)
        dfs(heights, i, n - 1, atlantic)

    for j in range(n):
        dfs(heights, 0, j, pacific)
        dfs(heights, m - 1, j, atlantic)

    result = []
    for i in range(m):
        for j in range(n):
            if pacific[i][j] and atlantic[i][j]:
                result.append([i, j])

    return result


"""
DFS to mark all reachable cells from an ocean
"""


def dfs(heights, row, col, visited):
    visited[row][col] = True
    directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

    for dr, dc in directions:
        nr, nc = row + dr, col + dc
        if is_safe(heights, nr, nc, heights[row][col], visited):
            dfs(heights, nr, nc, visited)


"""
Check bounds, visited state, and height condition
"""


def is_safe(heights, r, c, prev_height, visited):
    m, n = len(heights), len(heights[0])
    return (
        0 <= r < m and
        0 <= c < n and
        not visited[r][c] and
        heights[r][c] >= prev_height
    )


# -------------------- TEST --------------------
if __name__ == "__main__":
    heights = [
        [1, 2, 2, 3, 5],
        [3, 2, 3, 4, 4],
        [2, 4, 5, 3, 1],
        [6, 7, 1, 4, 5],
        [5, 1, 1, 2, 4]
    ]

    print(pacific_atlantic(heights))
