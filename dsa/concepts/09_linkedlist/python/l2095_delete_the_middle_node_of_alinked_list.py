"""
Problem: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

Idea:
Use fast and slow pointers to find the middle.
We want slow to stop one node *before* the middle node.
So we move fast two steps ahead before starting the loop.
Then delete slow.next (the middle node).
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def deleteMiddle(head: ListNode) -> ListNode:
    if head is None or head.next is None:
        return None

    slow = head
    fast = head.next.next      # skip one step so slow stops before middle

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    # delete middle node
    slow.next = slow.next.next
    return head


# Example usage
if __name__ == "__main__":
    # Create linked list: 1 -> 2 -> 3 -> 4 -> 5
    head = ListNode(1,
            ListNode(2,
            ListNode(3,
            ListNode(4,
            ListNode(5)))))

    head = deleteMiddle(head)

    # Print result: 1 -> 2 -> 4 -> 5
    curr = head
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
