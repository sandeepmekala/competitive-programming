"""
Problem: https://leetcode.com/problems/linked-list-cycle/

Idea:
Use Floyds Cycle Detection algorithm.
Use slow and fast ptr's. They can meet at any node.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def has_cycle(head: ListNode) -> bool:
    slow = fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
        if slow is fast:
            return True

    return False


# Example usage
if __name__ == "__main__":
    # Create linked list: 3 -> 2 -> 0 -> -4
    # And make a cycle: -4 -> 2
    n1 = ListNode(3)
    n2 = ListNode(2)
    n3 = ListNode(0)
    n4 = ListNode(-4)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n2   # cycle here

    print(has_cycle(n1))  # True
