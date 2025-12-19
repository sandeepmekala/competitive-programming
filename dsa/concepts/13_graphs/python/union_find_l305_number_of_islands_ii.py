from typing import List


class UnionFind:
    def __init__(self, size: int):
        self.parent = list(range(size))
        self.rank = [0] * size

    def find(self, x: int) -> int:
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]

    def union(self, x: int, y: int) -> None:
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
Problem:
Number of Islands II (Dynamic island addition).

Idea:
- Initially the grid is all water.
- Each operator turns a water cell into land.
- Maintain number of islands dynamically using Union-Find.
- When a new land is added, increment island count.
- Union it with adjacent lands (if any).
- Each successful union reduces island count by 1.

Time:
O(k * α(n)) where k = number of operations

Space:
O(m * n)
"""
def num_of_islands(m: int, n: int, operators: List[List[int]]) -> List[int]:
    uf = UnionFind(m * n)
    visited = [[0] * n for _ in range(m)]
    count = 0
    result = []

    directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

    for r, c in operators:
        if visited[r][c] == 1:
            result.append(count)
            continue

        visited[r][c] = 1
        count += 1

        node = r * n + c
        for dr, dc in directions:
            nr, nc = r + dr, c + dc
            if 0 <= nr < m and 0 <= nc < n and visited[nr][nc] == 1:
                adj_node = nr * n + nc
                if uf.find(node) != uf.find(adj_node):
                    uf.union(node, adj_node)
                    count -= 1

        result.append(count)

    return result


# ------------ test (same as Java main) ------------
if __name__ == "__main__":
    m, n = 4, 5
    operators = [
        [0, 0], [0, 0], [1, 1], [1, 0], [0, 1],
        [0, 3], [1, 3], [0, 4], [3, 2], [2, 2],
        [1, 2], [0, 2]
    ]

    print(num_of_islands(m, n, operators))
