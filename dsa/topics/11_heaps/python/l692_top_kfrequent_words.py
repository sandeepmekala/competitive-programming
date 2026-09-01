import heapq
from collections import Counter

"""
Problem: https://leetcode.com/problems/top-k-frequent-words/
Companies: Amazon

Idea: Hashing and Priority Queue
"""
def topKFrequent(words, k):
    # Count frequency of each word
    freq = Counter(words)

    # Min heap with custom ordering:
    # higher freq first, lexicographically smaller first
    heap = [(-count, word) for word, count in freq.items()]
    heapq.heapify(heap)

    result = []
    for _ in range(k):
        result.append(heapq.heappop(heap)[1])

    return result


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    words = ["i", "love", "leetcode", "i", "love", "coding"]
    print(topKFrequent(words, 2))  # ['i', 'love']
