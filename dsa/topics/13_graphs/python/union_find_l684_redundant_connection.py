from typing import List


class UnionFind:
    def __init__(self, n: int):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int) -> bool:
        px, py = self.find(x), self.find(y)
        if px == py:
            return False

        if self.rank[px] < self.rank[py]:
            self.parent[px] = py
        elif self.rank[px] > self.rank[py]:
            self.parent[py] = px
        else:
            self.parent[py] = px
            self.rank[px] += 1

        return True


"""
Problem:
Redundant Connection

Idea:
- The graph initially forms a tree.
- Adding one extra edge introduces a cycle.
- While processing edges, if two nodes already belong
  to the same set, that edge is redundant.

Approach:
- Use Union-Find with path compression.
- For each edge:
    - If both nodes have same parent → redundant edge
    - Else union them

Time:
O(n α(n))

Space:
O(n)
"""
def find_redundant_connection(edges: List[List[int]]) -> List[int]:
    n = len(edges) + 1
    uf = UnionFind(n)

    for u, v in edges:
        if not uf.union(u, v):
            return [u, v]

    return []


# ------------ test (same as Java main) ------------
if __name__ == "__main__":
    edges = [[1, 2], [1, 3], [2, 3]]
    print(find_redundant_connection(edges))
