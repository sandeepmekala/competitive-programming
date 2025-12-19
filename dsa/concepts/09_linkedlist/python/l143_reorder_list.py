"""
Problem: https://leetcode.com/problems/reorder-list/

Idea:
Split the list, reverse the second list and merge.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reorder_list(head: ListNode) -> None:
    if not head or not head.next or not head.next.next:
        return

    # Step 1: split the list
    head2 = split(head)

    # Step 2: reverse second half
    head2 = reverse(head2)

    # Step 3: merge alternately
    curr1, curr2 = head, head2
    while curr1 and curr2:
        next1 = curr1.next
        next2 = curr2.next

        curr1.next = curr2
        curr2.next = next1

        curr1 = next1
        curr2 = next2


def reverse(head: ListNode) -> ListNode:
    prev = None
    curr = head
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt
    return prev


def split(head: ListNode) -> ListNode:
    slow = head
    fast = head.next      # delay slow by one step
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    head2 = slow.next
    slow.next = None
    return head2


# Example usage
if __name__ == "__main__":
    # 1 -> 2 -> 3 -> 4
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n4 = ListNode(4)

    n1.next = n2
    n2.next = n3
    n3.next = n4

    reorder_list(n1)

    curr = n1
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    # Output: 1 4 2 3
