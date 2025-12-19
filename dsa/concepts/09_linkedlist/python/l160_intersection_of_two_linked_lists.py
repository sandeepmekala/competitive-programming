"""
Problem: https://leetcode.com/problems/intersection-of-two-linked-lists/

Idea:
Exchange curr1 and curr2 when they reach end of their respective lists.
They will meet at the intersection node.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def get_intersection_node(head1: ListNode, head2: ListNode) -> ListNode:
    curr1, curr2 = head1, head2

    while curr1 is not curr2:
        curr1 = curr1.next if curr1 else head2
        curr2 = curr2.next if curr2 else head1

    return curr1


# Example usage
if __name__ == "__main__":
    # Create intersecting lists
    # A: 1 -> 2 -> 3 \
    #                   -> 8 -> 9
    # B:       4 -> 5 /
    intersect = ListNode(8, ListNode(9))

    a1 = ListNode(1, ListNode(2, ListNode(3, intersect)))
    b1 = ListNode(4, ListNode(5, intersect))

    node = get_intersection_node(a1, b1)
    print(node.val if node else None)  # 8
