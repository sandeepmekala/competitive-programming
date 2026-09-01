"""
Problem: https://leetcode.com/problems/odd-even-linked-list/

Idea:
Use two pointers to keep track of odd and even nodes.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def odd_even_list(head: ListNode) -> ListNode:
    if not head or not head.next:
        return head

    odd = head
    even = head.next
    even_head = even   # store start of even list

    while even and even.next:
        odd.next = odd.next.next
        even.next = even.next.next

        odd = odd.next
        even = even.next

    odd.next = even_head
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

    head = odd_even_list(head)

    curr = head
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    # Output: 1 3 5 2 4
