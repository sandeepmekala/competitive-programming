"""
Problem: https://leetcode.com/problems/merge-two-sorted-lists/
Idea:
Similar technique as merging two sorted arrays.
Use two pointers and build the merged list in sorted order.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def merge_two_lists(head1: ListNode, head2: ListNode) -> ListNode:
    dummy = ListNode(-1)
    curr = dummy

    curr1 = head1
    curr2 = head2

    while curr1 and curr2:
        if curr1.val < curr2.val:
            curr.next = curr1
            curr1 = curr1.next
        else:
            curr.next = curr2
            curr2 = curr2.next
        curr = curr.next

    # Attach remaining nodes
    if curr1:
        curr.next = curr1
    if curr2:
        curr.next = curr2

    return dummy.next


# Example usage
if __name__ == "__main__":
    # List 1: 1 -> 2 -> 4
    l1 = ListNode(1, ListNode(2, ListNode(4)))

    # List 2: 1 -> 3 -> 4
    l2 = ListNode(1, ListNode(3, ListNode(4)))

    head = merge_two_lists(l1, l2)

    # Print merged list: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    while head:
        print(head.val, end=" ")
        head = head.next
