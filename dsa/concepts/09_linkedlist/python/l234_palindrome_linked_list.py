"""
Problem: https://leetcode.com/problems/palindrome-linked-list/

Idea:
Split the linked list and reverse the second half
and compare both the half elements one by one.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def is_palindrome(head: ListNode) -> bool:
    if not head or not head.next:
        return True

    # Step 1: split list
    middle = split(head)

    # Step 2: reverse second half
    head2 = reverse(middle)

    # Step 3: compare both halves
    curr1, curr2 = head, head2
    while curr2:
        if curr1.val != curr2.val:
            return False
        curr1 = curr1.next
        curr2 = curr2.next

    return True


# Incase even len list, we need to stop slow ptr at first middle node
# In that case, fast ptr will stop at second last node. Hence fast.next.next != null.
# Incase odd len list, fast ptr will stop at last node. Hence fast.next != null.
def split(head: ListNode) -> ListNode:
    slow = fast = head
    while fast.next and fast.next.next:
        slow = slow.next
        fast = fast.next.next

    head2 = slow.next
    slow.next = None
    return head2


def reverse(head: ListNode) -> ListNode:
    prev = None
    curr = head
    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt
    return prev


# Example usage
if __name__ == "__main__":
    # 1 -> 2 -> 3 -> 2 -> 1
    vals = [1, 2, 3, 2, 1]
    head = None
    curr = None

    for v in vals:
        node = ListNode(v)
        if not head:
            head = curr = node
        else:
            curr.next = node
            curr = curr.next

    print(is_palindrome(head))  # True
