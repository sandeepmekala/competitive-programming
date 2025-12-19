"""
Problem: https://leetcode.com/problems/plus-one-linked-list/

Idea:
Find the rightmost digit which is not 9.
Increment it and set all digits to its right as 0.
If all digits are 9, add a new node at the beginning.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def plus_one(head: ListNode) -> ListNode:
    if not head:
        return ListNode(1)

    # Find the rightmost node which is not 9
    not_nine = None
    curr = head

    while curr:
        if curr.val != 9:
            not_nine = curr
        curr = curr.next

    # Case 1: All digits are 9
    if not_nine is None:
        new_head = ListNode(1)
        new_head.next = head
        curr = head
        while curr:
            curr.val = 0
            curr = curr.next
        return new_head

    # Case 2: Increment rightmost non-9 digit
    not_nine.val += 1

    # Set all digits after it to 0
    curr = not_nine.next
    while curr:
        curr.val = 0
        curr = curr.next

    return head


# Example usage
if __name__ == "__main__":
    # 1 -> 2 -> 3 -> 4 -> 5
    vals = [1, 2, 3, 4, 5]
    head = None
    curr = None

    for v in vals:
        node = ListNode(v)
        if not head:
            head = curr = node
        else:
            curr.next = node
            curr = curr.next

    head = plus_one(head)

    curr = head
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    # Output: 1 2 3 4 6
