import heapq

"""
Problem: https://leetcode.com/problems/k-closest-points-to-origin/
Idea: Maintain a max heap of size k based on squared Euclidean distance.
      If heap size exceeds k, remove the farthest point.
"""
def k_closest(points, k):
    max_heap = []

    for x, y in points:
        dist = x*x + y*y
        heapq.heappush(max_heap, (-dist, x, y))
        if len(max_heap) > k:
            heapq.heappop(max_heap)

    result = []
    while max_heap:
        _, x, y = heapq.heappop(max_heap)
        result.append([x, y])

    return result


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    points = [[6, 10], [-3, 3], [-2, 5], [0, 2]]
    res = k_closest(points, 3)
    for p in res:
        print(p)
