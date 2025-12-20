"""
Problem: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Idea:
First move right pointer by n nodes.
Then move both left and right pointers until right.next is null.
Now the left node points to (n+1)th node from the end.
Remove the nth node from the end.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def remove_nth_from_end(head: ListNode, n: int) -> ListNode:
    left = head
    right = head

    # Move right pointer n steps ahead
    for _ in range(n):
        right = right.next

    # If right is null, remove head
    if right is None:
        return head.next

    # Delay left pointer by one node
    right = right.next

    while right:
        left = left.next
        right = right.next

    # Remove nth node from end
    left.next = left.next.next
    return head


# Example usage
if __name__ == "__main__":
    # List: 1 -> 2 -> 3 -> 4
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))

    head = remove_nth_from_end(head, 4)

    # Print result: 2 -> 3 -> 4
    while head:
        print(head.val, end=" ")
        head = head.next
