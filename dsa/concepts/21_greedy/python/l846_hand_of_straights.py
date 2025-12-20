import heapq
from collections import Counter

# Problem: https://leetcode.com/problems/hand-of-straights/
# Idea: Every time get the minimum number and check if min+1, min+2 ... up to groupSize
# exist in the hand.
# There can be duplicates, so maintain a count map.
# Use a min-heap to always get the smallest available number.
# Reduce count as numbers are used; remove from heap when count becomes 0.
# If an expected number is missing or heap order breaks, return false.

def isNStraightHand(hand, groupSize):
    if len(hand) % groupSize != 0:
        return False

    counts = Counter(hand)
    minHeap = list(counts.keys())
    heapq.heapify(minHeap)

    while minHeap:
        start = minHeap[0]
        for x in range(start, start + groupSize):
            if counts[x] == 0:
                return False

            counts[x] -= 1

            # remove from heap only when count becomes zero
            if counts[x] == 0:
                if minHeap and minHeap[0] == x:
                    heapq.heappop(minHeap)
                else:
                    return False

    return True


# -------- Test --------
hand = [1, 2, 3, 6, 2, 3, 4, 7, 8]
print(isNStraightHand(hand, 3))   # True
