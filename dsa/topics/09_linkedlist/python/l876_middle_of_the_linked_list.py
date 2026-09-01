"""
Problem: https://leetcode.com/problems/middle-of-the-linked-list/

Idea:
Use fast and slow pointers
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def middle_node(head: ListNode) -> ListNode:
    slow = fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    return slow


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

    mid = middle_node(head)
    print(mid.val)  # 3
