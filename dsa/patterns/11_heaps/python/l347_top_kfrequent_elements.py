from typing import List
from collections import defaultdict

"""
Problem: https://leetcode.com/problems/top-k-frequent-elements/
Idea: This can be solved using heap.
Alternative: Hashing and create buckets based on freq.
All the nums of same freq would fall in same bucket.
Look into buckets from the end as max freq value bucket is at the end.
"""
def topKFrequent(nums: List[int], k: int) -> List[int]:

    # Frequency map
    freq = defaultdict(int)
    for num in nums:
        freq[num] += 1

    # Buckets where index = frequency
    # Top freq can be len(nums) if all nums are same
    buckets = [[] for _ in range(len(nums) + 1)]
    for num, f in freq.items():
        buckets[f].append(num)

    # Collect result from highest frequency bucket
    result = []
    for f in range(len(buckets) - 1, 0, -1):
        for num in buckets[f]:
            result.append(num)
            if len(result) == k:
                return result

    return result


# ---- one test (similar to Java main) ----
if __name__ == "__main__":
    print(topKFrequent([1, 1, 1, 2, 2, 3, 3, 4], 2))
