"""
Problem: https://leetcode.com/problems/linked-list-cycle-ii

Idea:
    Step 1: Detect cycle using FCD.
    Step 2: Place one pointer at head of LL | Another pointer should be at the point where fast and slow meet.
    Step 3: Move 1st pointer and 2nd pointer by one step each.
    Step 4: Both will meet again at entry point of cycle.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def detect_cycle(head: ListNode) -> ListNode:
    slow = fast = head

    # Step 1: Detect cycle
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow is fast:
            # Step 2: Move slow to head
            slow = head
            # Step 3 & 4: Move both one step at a time
            while slow is not fast:
                slow = slow.next
                fast = fast.next
            return slow

    return None


# Example usage
if __name__ == "__main__":
    # Create linked list: 3 -> 2 -> 0 -> -4
    # Create cycle: -4 -> 2
    n1 = ListNode(3)
    n2 = ListNode(2)
    n3 = ListNode(0)
    n4 = ListNode(-4)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n2   # cycle entry

    entry = detect_cycle(n1)
    print(entry.val if entry else None)  # 2
