# Fenwick Tree / Binary Indexed Tree
# Idea:
# 1. update(i, val): Add `val` at index i and update all affected indices.
# 2. query(i): Get prefix sum from 1 to i.
# 3. rangeQuery(i, j): query(j) - query(i-1)
# 4. find(k): Binary lifting to find lower bound index with prefix sum >= k.
# Time: O(log n) for update, query, find

import math

class FenwickTree:
    def __init__(self, n):
        self.n = n
        self.fen = [0] * (n + 1)

    def update(self, i, add):
        # Update all affected indices
        while i <= self.n:
            self.fen[i] += add
            i += i & -i

    def query(self, i):
        # Prefix sum from 1 to i
        s = 0
        while i > 0:
            s += self.fen[i]
            i -= i & -i
        return s

    def range_query(self, i, j):
        return self.query(j) - self.query(i - 1)

    def find(self, k):
        # Binary lifting to find lower bound index
        curr = 0
        prev_sum = 0
        max_pow = int(math.log2(self.n)) + 1
        for i in reversed(range(max_pow)):
            next_idx = curr + (1 << i)
            if next_idx <= self.n and prev_sum + self.fen[next_idx] < k:
                curr = next_idx
                prev_sum += self.fen[curr]
        return curr + 1

# -------- Test --------
ft = FenwickTree(5)
ft.update(1, 2)
ft.update(2, 3)
ft.update(3, 4)
ft.update(4, 5)

print(ft.query(3))         # Expected: 9
print(ft.range_query(1, 3)) # Expected: 9
print(ft.find(8))           # Expected: 3
print(ft.query(ft.find(8))) # Expected: 9
