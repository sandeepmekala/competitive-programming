"""
Problem: https://leetcode.com/problems/reverse-linked-list/

Idea:
Use prev, curr and next ptr's
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reverse_list(head: ListNode) -> ListNode:
    prev = None
    curr = head

    while curr:
        nxt = curr.next
        curr.next = prev
        prev = curr
        curr = nxt

    return prev


def reverse_rec(node: ListNode) -> ListNode:
    if not node or not node.next:
        return node

    new_head = reverse_rec(node.next)
    node.next.next = node
    node.next = None

    return new_head


# Example usage
if __name__ == "__main__":
    # 1 -> 2 -> 3
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)

    n1.next = n2
    n2.next = n3

    head = reverse_list(n1)
    # head = reverse_rec(head)

    curr = head
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    # Output: 3 2 1
