"""
Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
Idea:
Compare curr and curr.next vals.
If equal, change curr.next to curr.next.next.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def delete_duplicates(head: ListNode) -> ListNode:
    curr = head

    while curr and curr.next:
        if curr.val == curr.next.val:
            curr.next = curr.next.next
        else:
            curr = curr.next

    return head


# Example usage
if __name__ == "__main__":
    head = ListNode(2,
            ListNode(2,
            ListNode(3,
            ListNode(3,
            ListNode(4)))))

    head = delete_duplicates(head)

    while head:
        print(head.val, end=" ")
        head = head.next
