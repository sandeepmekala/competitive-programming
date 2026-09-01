import heapq

class MedianFinder:
    """
    Problem: https://leetcode.com/problems/find-median-from-data-stream/

    Idea:
    Use 2 heaps.
    Store half elements in each heap.
    If odd number of elements, store one extra element in max heap.

    max_heap -> stores smaller half (as max heap)
    min_heap -> stores larger half (as min heap)

    Median can be derived from the top of heaps.
    """

    def __init__(self):
        self.max_heap = []   # max heap (store negatives)
        self.min_heap = []   # min heap

    def addNum(self, num: int) -> None:
        # Step 1: Always push to max heap first
        heapq.heappush(self.max_heap, -num)

        # Step 2: Balance order (max_heap top <= min_heap top)
        if self.min_heap and -self.max_heap[0] > self.min_heap[0]:
            heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))

        # Step 3: Balance size (max_heap can have at most 1 extra element)
        if len(self.max_heap) > len(self.min_heap) + 1:
            heapq.heappush(self.min_heap, -heapq.heappop(self.max_heap))
        elif len(self.min_heap) > len(self.max_heap):
            heapq.heappush(self.max_heap, -heapq.heappop(self.min_heap))

    def findMedian(self) -> float:
        if len(self.max_heap) == len(self.min_heap):
            return (-self.max_heap[0] + self.min_heap[0]) / 2.0
        return -self.max_heap[0]


if __name__ == "__main__":
    mf = MedianFinder()
    mf.addNum(1)
    mf.addNum(2)
    print(mf.findMedian())   # 1.5
    mf.addNum(3)
    print(mf.findMedian())   # 2
