import heapq

"""
Problem: https://leetcode.com/problems/last-stone-weight/
Smash the stones. Return remaining last stone weight.
Idea: Use max heap as we need max elements always
"""
def last_stone_weight(stones):
    max_heap = [-stone for stone in stones]
    heapq.heapify(max_heap)

    while len(max_heap) > 1:
        y = -heapq.heappop(max_heap)
        x = -heapq.heappop(max_heap)
        if y != x:
            heapq.heappush(max_heap, -(y - x))

    return -max_heap[0] if max_heap else 0


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    print(last_stone_weight([2, 7, 4, 1, 8, 1]))
