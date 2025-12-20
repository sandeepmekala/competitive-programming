# Segment Tree for Range Minimum Query
# Idea:
# 1. Build tree in array. Root at 0, left: 2*i+1, right: 2*i+2
# 2. Range minimum query O(log n)
# 3. Point update O(log n)
# 4. Range update with lazy propagation O(log n)
# Time: O(n) build, O(log n) query/update

import math

class SegmentTreeRMQ:
    def create_segment_tree(self, nums):
        n = len(nums)
        size = 2 * (2 ** math.ceil(math.log2(n))) - 1
        seg = [float('inf')] * size
        self._construct(seg, nums, 0, n-1, 0)
        return seg

    def _construct(self, seg, nums, low, high, pos):
        if low == high:
            seg[pos] = nums[low]
            return
        mid = (low + high) // 2
        self._construct(seg, nums, low, mid, 2*pos+1)
        self._construct(seg, nums, mid+1, high, 2*pos+2)
        seg[pos] = min(seg[2*pos+1], seg[2*pos+2])

    def update_point(self, nums, seg, index, delta):
        nums[index] += delta
        self._update_point(seg, index, delta, 0, len(nums)-1, 0)

    def _update_point(self, seg, index, delta, low, high, pos):
        if index < low or index > high:
            return
        if low == high:
            seg[pos] += delta
            return
        mid = (low + high) // 2
        self._update_point(seg, index, delta, low, mid, 2*pos+1)
        self._update_point(seg, index, delta, mid+1, high, 2*pos+2)
        seg[pos] = min(seg[2*pos+1], seg[2*pos+2])

    def update_range(self, nums, seg, start, end, delta):
        for i in range(start, end+1):
            nums[i] += delta
        self._update_range(seg, start, end, delta, 0, len(nums)-1, 0)

    def _update_range(self, seg, start, end, delta, low, high, pos):
        if low > high or start > high or end < low:
            return
        if low == high:
            seg[pos] += delta
            return
        mid = (low + high) // 2
        self._update_range(seg, start, end, delta, low, mid, 2*pos+1)
        self._update_range(seg, start, end, delta, mid+1, high, 2*pos+2)
        seg[pos] = min(seg[2*pos+1], seg[2*pos+2])

    def range_min_query(self, seg, qlow, qhigh, n):
        return self._range_min_query(seg, 0, n-1, qlow, qhigh, 0)

    def _range_min_query(self, seg, low, high, qlow, qhigh, pos):
        if qlow <= low and qhigh >= high:  # total overlap
            return seg[pos]
        if qlow > high or qhigh < low:     # no overlap
            return float('inf')
        mid = (low + high) // 2
        left = self._range_min_query(seg, low, mid, qlow, qhigh, 2*pos+1)
        right = self._range_min_query(seg, mid+1, high, qlow, qhigh, 2*pos+2)
        return min(left, right)

    # Lazy propagation range update
    def update_range_lazy(self, seg, lazy, start, end, delta, n):
        self._update_range_lazy(seg, lazy, start, end, delta, 0, n-1, 0)

    def _update_range_lazy(self, seg, lazy, start, end, delta, low, high, pos):
        if low > high:
            return
        if lazy[pos] != 0:
            seg[pos] += lazy[pos]
            if low != high:
                lazy[2*pos+1] += lazy[pos]
                lazy[2*pos+2] += lazy[pos]
            lazy[pos] = 0
        if start > high or end < low:
            return
        if start <= low and end >= high:
            seg[pos] += delta
            if low != high:
                lazy[2*pos+1] += delta
                lazy[2*pos+2] += delta
            return
        mid = (low + high) // 2
        self._update_range_lazy(seg, lazy, start, end, delta, low, mid, 2*pos+1)
        self._update_range_lazy(seg, lazy, start, end, delta, mid+1, high, 2*pos+2)
        seg[pos] = min(seg[2*pos+1], seg[2*pos+2])

    def range_min_query_lazy(self, seg, lazy, qlow, qhigh, n):
        return self._range_min_query_lazy(seg, lazy, qlow, qhigh, 0, n-1, 0)

    def _range_min_query_lazy(self, seg, lazy, qlow, qhigh, low, high, pos):
        if low > high:
            return float('inf')
        if lazy[pos] != 0:
            seg[pos] += lazy[pos]
            if low != high:
                lazy[2*pos+1] += lazy[pos]
                lazy[2*pos+2] += lazy[pos]
            lazy[pos] = 0
        if qlow > high or qhigh < low:
            return float('inf')
        if qlow <= low and qhigh >= high:
            return seg[pos]
        mid = (low + high) // 2
        left = self._range_min_query_lazy(seg, lazy, qlow, qhigh, low, mid, 2*pos+1)
        right = self._range_min_query_lazy(seg, lazy, qlow, qhigh, mid+1, high, 2*pos+2)
        return min(left, right)

# -------- Test --------
nums = [0,3,4,2,1,6,-1]
st = SegmentTreeRMQ()
segTree = st.create_segment_tree(nums)
n = len(nums)

# Non-lazy queries
assert st.range_min_query(segTree, 0, 3, n) == 0
assert st.range_min_query(segTree, 1, 5, n) == 1
assert st.range_min_query(segTree, 1, 6, n) == -1
st.update_point(nums, segTree, 2, 1)
assert st.range_min_query(segTree, 1, 3, n) == 2
st.update_range(nums, segTree, 3, 5, -2)
assert st.range_min_query(segTree, 5, 6, n) == -1
assert st.range_min_query(segTree, 0, 3, n) == 0

# Lazy propagation example
nums1 = [-1,2,4,1,7,1,3,2]
segTree1 = st.create_segment_tree(nums1)
lazy1 = [0] * len(segTree1)
st.update_range_lazy(segTree1, lazy1, 0, 3, 1, len(nums1))
st.update_range_lazy(segTree1, lazy1, 0, 0, 2, len(nums1))
assert st.range_min_query_lazy(segTree1, lazy1, 3, 5, len(nums1)) == 1
