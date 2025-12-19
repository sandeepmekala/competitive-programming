"""
Problem: https://leetcode.com/problems/rotate-list/
Idea:
Go to end and make the list circular.
Then traverse again and make n-kth node head.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def rotate_right(head: ListNode, k: int) -> ListNode:
    if not head or not head.next:
        return head

    # make the list circular and calculate length
    n = 1
    curr = head
    while curr.next:
        n += 1
        curr = curr.next

    curr.next = head  # circular link

    k = k % n
    if k == 0:
        curr.next = None
        return head

    # find (n-k)th node
    curr = head
    for _ in range(n - k - 1):
        curr = curr.next

    new_head = curr.next
    curr.next = None

    return new_head


# Example usage
if __name__ == "__main__":
    head = ListNode(1,
            ListNode(2,
            ListNode(3,
            ListNode(4,
            ListNode(5)))))

    head = rotate_right(head, 2)

    while head:
        print(head.val, end=" ")
        head = head.next
