from typing import List


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
Problem: Number of Operations to Make Network Connected
https://leetcode.com/problems/number-of-operations-to-make-network-connected/

Idea:
- Use Union Find (DSU) to track connected components.
- If an edge connects two already-connected nodes, it is an extra cable.
- To connect k components, we need (k - 1) cables.
- If extra cables >= required cables, return (components - 1), else return -1.

Time Complexity: O(n + connections * α(n))
Space Complexity: O(n)
"""
def make_connected(n: int, connections: List[List[int]]) -> int:
    uf = UnionFind(n)
    extra_connections = 0

    for u, v in connections:
        if uf.find(u) == uf.find(v):
            extra_connections += 1
        else:
            uf.union_by_rank(u, v)

    components = 0
    for i in range(n):
        if uf.find(i) == i:
            components += 1

    required = components - 1
    return required if extra_connections >= required else -1


# ---------------- test (same as Java main) ----------------
if __name__ == "__main__":
    n = 5
    connections = [[0, 1], [0, 2], [3, 4], [2, 3]]
    print(make_connected(n, connections))
