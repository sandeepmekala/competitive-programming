# Segment Tree
# Idea:
# 1. Tree stored in array. Root at index 0.
# 2. Left child: 2*i + 1, Right child: 2*i + 2
# 3. Build, query, and point update recursively.
# 4. Lazy propagation used for efficient range updates.
# Time: O(log n) per query/update, O(n) to build
# Space: O(4*n) for segment tree array

import math

class SegmentTree:
    def build(self, nums):
        n = len(nums)
        size = 2 * (2 ** (math.ceil(math.log2(n)))) - 1
        seg = [float('inf')] * size
        self._build(nums, seg, 0, 0, n - 1)
        return seg

    def _build(self, nums, seg, ind, low, high):
        if low == high:
            seg[ind] = nums[low]
            return
        mid = (low + high) // 2
        self._build(nums, seg, 2*ind+1, low, mid)
        self._build(nums, seg, 2*ind+2, mid+1, high)
        seg[ind] = min(seg[2*ind+1], seg[2*ind+2])

    def query_range_min(self, seg, ind, low, high, ql, qr):
        if low >= ql and high <= qr:  # fully overlapping
            return seg[ind]
        if low > qr or high < ql:     # no overlap
            return float('inf')
        mid = (low + high) // 2
        left = self.query_range_min(seg, 2*ind+1, low, mid, ql, qr)
        right = self.query_range_min(seg, 2*ind+2, mid+1, high, ql, qr)
        return min(left, right)

    def update_point_sum(self, seg, ind, low, high, index, value):
        if low == high:
            seg[ind] += value
            return
        mid = (low + high) // 2
        if index <= mid:
            self.update_point_sum(seg, 2*ind+1, low, mid, index, value)
        else:
            self.update_point_sum(seg, 2*ind+2, mid+1, high, index, value)
        seg[ind] = min(seg[2*ind+1], seg[2*ind+2])

    # Lazy propagation for range updates
    def update_range_sum_lazy(self, seg, lazy, ind, low, high, ql, qr, value):
        if lazy[ind] != 0:
            seg[ind] += (high - low + 1) * lazy[ind]
            if low != high:
                lazy[2*ind+1] += lazy[ind]
                lazy[2*ind+2] += lazy[ind]
            lazy[ind] = 0

        if low > qr or high < ql:
            return

        if low >= ql and high <= qr:
            seg[ind] += (high - low + 1) * value
            if low != high:
                lazy[2*ind+1] += value
                lazy[2*ind+2] += value
            return

        mid = (low + high) // 2
        self.update_range_sum_lazy(seg, lazy, 2*ind+1, low, mid, ql, qr, value)
        self.update_range_sum_lazy(seg, lazy, 2*ind+2, mid+1, high, ql, qr, value)
        seg[ind] = min(seg[2*ind+1], seg[2*ind+2])

    def query_range_sum_lazy(self, seg, lazy, ind, low, high, l, r):
        if lazy[ind] != 0:
            seg[ind] += (high - low + 1) * lazy[ind]
            if low != high:
                lazy[2*ind+1] += lazy[ind]
                lazy[2*ind+2] += lazy[ind]
            lazy[ind] = 0

        if low > r or high < l:
            return 0

        if low >= l and high <= r:
            return seg[ind]

        mid = (low + high) // 2
        left = self.query_range_sum_lazy(seg, lazy, 2*ind+1, low, mid, l, r)
        right = self.query_range_sum_lazy(seg, lazy, 2*ind+2, mid+1, high, l, r)
        return left + right

# -------- Test --------
nums = [-1, 2, 4, 0]
st = SegmentTree()
n = len(nums)
seg = st.build(nums)
print("Segment tree:", seg)
print("Query range min 0-2:", st.query_range_min(seg, 0, 0, n-1, 0, 2))  #  -1
st.update_point_sum(seg, 0, 0, n-1, 0, 3)
print("Query range min 0-2 after update:", st.query_range_min(seg, 0, 0, n-1, 0, 2))  # 2

# Lazy propagation example
lazy = [0] * len(seg)
st.update_range_sum_lazy(seg, lazy, 0, 0, n-1, 1, 3, 2)
print("Query range sum lazy 0-3:", st.query_range_sum_lazy(seg, lazy, 0, 0, n-1, 0, 3))
