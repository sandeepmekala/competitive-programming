class UnionFind:
    """
    Union-Find (Disjoint Set Union - DSU)

    Features:
    - Path Compression
    - Union by Rank
    - Union by Size

    Time Complexity:
    - Amortized O(α(n)) per operation

    Space Complexity:
    - O(n)
    """

    def __init__(self, n: int):
        self.parent = list(range(n + 1))
        self.rank = [0] * (n + 1)
        self.size = [1] * (n + 1)

    """
    Path Compression:
    Flattens the tree by making every node point directly to the root.
    """
    def find(self, node: int) -> int:
        if self.parent[node] != node:
            self.parent[node] = self.find(self.parent[node])
        return self.parent[node]

    """
    Union by Rank:
    Attach the tree with smaller rank under the tree with larger rank.
    If ranks are equal, increment the rank of the new root.
    """
    def union_by_rank(self, u: int, v: int) -> None:
        pu, pv = self.find(u), self.find(v)
        if pu == pv:
            return

        if self.rank[pu] < self.rank[pv]:
            self.parent[pu] = pv
        elif self.rank[pv] < self.rank[pu]:
            self.parent[pv] = pu
        else:
            self.parent[pv] = pu
            self.rank[pu] += 1

    """
    Union by Size:
    Attach the smaller tree under the larger tree.
    """
    def union_by_size(self, u: int, v: int) -> None:
        pu, pv = self.find(u), self.find(v)
        if pu == pv:
            return

        if self.size[pu] < self.size[pv]:
            self.parent[pu] = pv
            self.size[pv] += self.size[pu]
        else:
            self.parent[pv] = pu
            self.size[pu] += self.size[pv]

    def get_size(self, node: int) -> int:
        return self.size[self.find(node)]


# ---------------- test (equivalent to Java main) ----------------
if __name__ == "__main__":
    uf = UnionFind(5)

    uf.union_by_rank(1, 2)
    uf.union_by_rank(2, 3)
    uf.union_by_rank(4, 5)
    uf.union_by_rank(3, 4)

    print(uf.find(1))
    print(uf.find(2))
    print(uf.find(3))
    print(uf.find(4))
