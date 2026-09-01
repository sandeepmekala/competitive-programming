"""
Problem: https://leetcode.com/problems/merge-k-sorted-lists/
Idea:
Push all the nodes to a min heap.
Pop the minimum node, add it to the result list,
and push its next node into the heap.
Time: O(k log k + n log k), Space: O(k)
"""

import heapq


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    # Required so heap can compare ListNode objects
    def __lt__(self, other):
        return self.val < other.val


def merge_k_lists(lists):
    min_heap = []

    # Push head of each list into heap
    for node in lists:
        if node:
            heapq.heappush(min_heap, node)

    dummy = ListNode(-1)
    curr = dummy

    while min_heap:
        node = heapq.heappop(min_heap)
        curr.next = node
        curr = curr.next

        if node.next:
            heapq.heappush(min_heap, node.next)

    return dummy.next


# Example usage
if __name__ == "__main__":
    # List 1: 1 -> 4 -> 5
    l1 = ListNode(1, ListNode(4, ListNode(5)))

    # List 2: 1 -> 3 -> 4
    l2 = ListNode(1, ListNode(3, ListNode(4)))

    # List 3: 2 -> 6
    l3 = ListNode(2, ListNode(6))

    merged = merge_k_lists([l1, l2, l3])

    # Print merged list: 1 1 2 3 4 4 5 6
    while merged:
        print(merged.val, end=" ")
        merged = merged.next
