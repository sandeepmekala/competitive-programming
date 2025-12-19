"""
Idea:
Each node has two pointers:
- next  → points to the next list
- bottom → points to a sorted linked list

Flatten the list by:
1. Recursively flattening the right (next) list
2. Merging the current list with the flattened list
"""

class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None
        self.bottom = None


def flatten(root: ListNode) -> ListNode:
    if root is None or root.next is None:
        return root

    # Flatten the list on the right
    merged_list = flatten(root.next)

    # Merge current list with the flattened list
    return merge_two_lists(root, merged_list)


def merge_two_lists(l1: ListNode, l2: ListNode) -> ListNode:
    dummy = ListNode(0)
    curr = dummy

    while l1 and l2:
        if l1.val < l2.val:
            curr.bottom = l1
            l1 = l1.bottom
        else:
            curr.bottom = l2
            l2 = l2.bottom
        curr = curr.bottom

    # Attach remaining nodes
    curr.bottom = l1 if l1 else l2

    return dummy.bottom


# Example usage
if __name__ == "__main__":
    head = ListNode(5)
    head.bottom = ListNode(7)
    head.bottom.bottom = ListNode(8)
    head.bottom.bottom.bottom = ListNode(30)

    head.next = ListNode(10)
    head.next.bottom = ListNode(20)

    head.next.next = ListNode(19)
    head.next.next.bottom = ListNode(22)
    head.next.next.bottom.bottom = ListNode(50)

    head.next.next.next = ListNode(28)
    head.next.next.next.bottom = ListNode(35)
    head.next.next.next.bottom.bottom = ListNode(40)

    head = flatten(head)

    # Print flattened list using bottom pointer
    while head:
        print(head.val, end=" ")
        head = head.bottom
