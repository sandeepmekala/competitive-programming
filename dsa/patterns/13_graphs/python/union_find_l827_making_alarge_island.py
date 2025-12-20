from typing import List
from collections import defaultdict


class UnionFind:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.size = [1] * n

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union_by_size(self, x: int, y: int) -> None:
        px, py = self.find(x), self.find(y)
        if px == py:
            return
        if self.size[px] < self.size[py]:
            self.parent[px] = py
            self.size[py] += self.size[px]
        else:
            self.parent[py] = px
            self.size[px] += self.size[py]

    def get_size(self, x: int) -> int:
        return self.size[self.find(x)]


"""
Problem: Making A Large Island
https://leetcode.com/problems/making-a-large-island/

Idea:
1. Treat each cell as a node (row * n + col).
2. Union all adjacent land cells (1s).
3. For each water cell (0), try flipping it:
   - Collect unique neighboring components.
   - Sum their sizes and add 1.
4. Track the maximum island size.
5. Edge case: if grid has no 0s, return the largest existing component.

Time Complexity: O(N² * α(N))
Space Complexity: O(N²)
"""
def largest_island(grid: List[List[int]]) -> int:
    n = len(grid)
    uf = UnionFind(n * n)

    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    # Step 1: Union adjacent land cells
    for r in range(n):
        for c in range(n):
            if grid[r][c] == 0:
                continue
            node = r * n + c
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n and grid[nr][nc] == 1:
                    uf.union_by_size(node, nr * n + nc)

    # Step 2: Try flipping each 0
    max_island = 0
    for r in range(n):
        for c in range(n):
            if grid[r][c] == 1:
                continue

            components = set()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n and grid[nr][nc] == 1:
                    components.add(uf.find(nr * n + nc))

            size_sum = 1
            for p in components:
                size_sum += uf.size[p]

            max_island = max(max_island, size_sum)

    # Step 3: Edge case — no zero in grid
    for cell in range(n * n):
        max_island = max(max_island, uf.get_size(cell))

    return max_island


# ---------------- test (same as Java main) ----------------
if __name__ == "__main__":
    grid = [
        [1, 1, 0, 1, 1, 0],
        [1, 1, 0, 1, 1, 0],
        [1, 1, 0, 1, 1, 0],
        [0, 0, 1, 0, 0, 0],
        [0, 0, 1, 1, 1, 0],
        [0, 0, 1, 1, 1, 0]
    ]

    print("The largest group of connected 1s is of size:", largest_island(grid))
