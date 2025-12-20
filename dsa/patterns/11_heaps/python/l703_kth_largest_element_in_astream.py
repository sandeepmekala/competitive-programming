import heapq

"""
Problem: https://leetcode.com/problems/kth-largest-element-in-a-stream/
Idea: Keep k largest elements in min heap so that top of the heap is kth largest.
"""
class KthLargest:
    def __init__(self, k, nums):
        self.k = k
        self.min_heap = []

        for num in nums:
            heapq.heappush(self.min_heap, num)
            if len(self.min_heap) > k:
                heapq.heappop(self.min_heap)

    def add(self, val):
        heapq.heappush(self.min_heap, val)
        if len(self.min_heap) > self.k:
            heapq.heappop(self.min_heap)

        if len(self.min_heap) < self.k:
            return -1

        return self.min_heap[0]


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    kthLargest = KthLargest(3, [4, 5, 8, 2])
    print(kthLargest.add(3))   # 4
    print(kthLargest.add(5))   # 5
    print(kthLargest.add(10))  # 5
    print(kthLargest.add(9))   # 8
    print(kthLargest.add(4))   # 8
