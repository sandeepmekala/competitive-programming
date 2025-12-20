"""
Problem: https://leetcode.com/problems/sort-list/

Idea:
Use merge sort, ll split techniques

Time: O((n + n/2)logn)
Space: O(1)
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def sort_list(head: ListNode) -> ListNode:
    if not head or not head.next:
        return head

    # split list into two halves
    head2 = split(head)

    # sort both halves
    left = sort_list(head)
    right = sort_list(head2)

    # merge sorted halves
    return merge(left, right)


def merge(head1: ListNode, head2: ListNode) -> ListNode:
    dummy = ListNode(-1)
    curr = dummy

    while head1 and head2:
        if head1.val <= head2.val:
            curr.next = head1
            head1 = head1.next
        else:
            curr.next = head2
            head2 = head2.next
        curr = curr.next

    curr.next = head1 if head1 else head2
    return dummy.next


def split(head: ListNode) -> ListNode:
    slow = head
    fast = head.next.next    # Skip one step for slow to stop at first mid for even nodes

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    head2 = slow.next
    slow.next = None
    return head2


# Example usage
if __name__ == "__main__":
    # 7 -> 10 -> 5 -> 20 -> 3 -> 2
    values = [7, 10, 5, 20, 3, 2]
    head = None
    curr = None

    for v in values:
        node = ListNode(v)
        if not head:
            head = curr = node
        else:
            curr.next = node
            curr = curr.next

    head = sort_list(head)

    while head:
        print(head.val, end=" ")
        head = head.next
    # Output: 2 3 5 7 10 20
