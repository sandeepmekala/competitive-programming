from collections import Counter
import heapq

"""
Problem: https://leetcode.com/problems/sort-characters-by-frequency/
Companies: Amazon
Idea: Hashing and Priority Queue
"""
def frequencySort(s: str) -> str:
    # Count frequency of each character
    freq = Counter(s)

    # Max heap based on frequency
    # Python has min-heap, so use negative frequency
    max_heap = [(-count, ch) for ch, count in freq.items()]
    heapq.heapify(max_heap)

    result = []
    while max_heap:
        count, ch = heapq.heappop(max_heap)
        result.append(ch * (-count))

    return "".join(result)


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    print(frequencySort("tree"))
