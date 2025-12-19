from typing import List, Set


class UnionFind:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union_by_rank(self, x: int, y: int) -> None:
        px, py = self.find(x), self.find(y)
        if px == py:
            return

        if self.rank[px] < self.rank[py]:
            self.parent[px] = py
        elif self.rank[px] > self.rank[py]:
            self.parent[py] = px
        else:
            self.parent[py] = px
            self.rank[px] += 1


"""
Problem: Most Stones Removed with Same Row or Column
https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

Idea:
- Treat each row index and column index as nodes in Union-Find.
- Offset column indices so row and column nodes don't collide.
- Union(row, col) for each stone.
- Count how many connected components exist among used nodes.
- Answer = total stones - number of connected components.

Time Complexity: O(N * α(N))
Space Complexity: O(N)
"""
def remove_stones(stones: List[List[int]]) -> int:
    n = len(stones)

    max_row = max(r for r, _ in stones)
    max_col = max(c for _, c in stones)

    uf = UnionFind(max_row + max_col + 2)
    used_nodes: Set[int] = set()

    for r, c in stones:
        col_node = c + max_row + 1
        uf.union_by_rank(r, col_node)
        used_nodes.add(r)
        used_nodes.add(col_node)

    components = 0
    for node in used_nodes:
        if uf.find(node) == node:
            components += 1

    return n - components


# ---------------- test (same as Java main) ----------------
if __name__ == "__main__":
    stones = [
        [0, 0],
        [0, 2],
        [1, 3],
        [3, 1],
        [3, 2],
        [4, 3]
    ]

    ans = remove_stones(stones)
    print("The maximum number of stones we can remove is:", ans)
