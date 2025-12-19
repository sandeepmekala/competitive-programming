"""
Problem: https://leetcode.com/problems/swap-nodes-in-pairs/
Idea:
Swap nodes in pairs by reusing reverse K group logic with k = 2.
Reverse nodes in groups of size k while maintaining links between groups.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def swap_pairs(head: ListNode) -> ListNode:
    return reverse_k_group(head, 2)


def reverse_k_group(head: ListNode, k: int) -> ListNode:
    if not head or k == 1:
        return head

    length = get_length(head)

    dummy = ListNode(-1)
    dummy.next = head

    prev = None
    curr = head
    prev_group_last = dummy

    while length >= k:
        curr_group_last = curr

        # reverse k nodes
        for _ in range(k):
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt

        # connect previous group to current reversed group
        prev_group_last.next = prev
        prev_group_last = curr_group_last

        prev = None
        length -= k

    # attach remaining nodes
    prev_group_last.next = curr

    return dummy.next


def get_length(head: ListNode) -> int:
    length = 0
    while head:
        length += 1
        head = head.next
    return length


# Example usage
if __name__ == "__main__":
    head = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))

    head = swap_pairs(head)

    while head:
        print(head.val, end=" ")
        head = head.next
