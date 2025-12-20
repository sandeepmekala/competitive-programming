"""
Problem: https://leetcode.com/problems/remove-linked-list-elements/

Idea:
We might have to remove head also.
To simplify that add start node.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def remove_elements(head: ListNode, val: int) -> ListNode:
    start = ListNode(0)
    start.next = head

    curr = start
    while curr and curr.next:
        if curr.next.val == val:
            curr.next = curr.next.next
        else:
            curr = curr.next

    return start.next


# Example usage
if __name__ == "__main__":
    # 2 -> 4 -> 3 -> 2, remove 2
    n1 = ListNode(2)
    n2 = ListNode(4)
    n3 = ListNode(3)
    n4 = ListNode(2)

    n1.next = n2
    n2.next = n3
    n3.next = n4

    head = remove_elements(n1, 2)

    curr = head
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    # Output: 4 3
