"""
Kruskal's Minimum Spanning Tree Algorithm

Idea:
- Sort all edges by weight
- Iterate edges and pick the smallest edge that does NOT form a cycle
- Use Union-Find (Disjoint Set) to detect cycles

Time Complexity:
O(E log E)

Space Complexity:
O(V)
"""


class Edge:
    def __init__(self, src, dest, weight):
        self.src = src
        self.dest = dest
        self.weight = weight

    def __lt__(self, other):
        return self.weight < other.weight


class UnionFind:
    """
    Union-Find with Path Compression and Union by Rank
    """

    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])   # path compression
        return self.parent[x]

    def union(self, x, y):
        px = self.find(x)
        py = self.find(y)

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


def kruskal_mst(edges, n):
    """
    Builds MST using Kruskal's algorithm
    """
    edges.sort()
    uf = UnionFind(n)

    mst = []
    for edge in edges:
        if uf.union(edge.src, edge.dest):
            mst.append(edge)

    return mst


# -------------------- TEST --------------------
if __name__ == "__main__":
    edges = [
        Edge(0, 1, 10),
        Edge(0, 2, 6),
        Edge(0, 3, 5),
        Edge(1, 3, 15),
        Edge(2, 3, 4),
    ]

    n = 4
    mst_edges = kruskal_mst(edges, n)

    min_cost = 0
    for e in mst_edges:
        print(f"{e.src} -> {e.dest}")
        min_cost += e.weight

    print("Min Cost:", min_cost)
