"""
Problem: https://leetcode.com/problems/delete-node-in-a-linked-list/

Idea:
Just swap the curr node val with next node val
and delete next node.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def delete_node(node: ListNode) -> None:
    node.val = node.next.val
    node.next = node.next.next


# Example usage
if __name__ == "__main__":
    # 4 -> 5 -> 1 -> 9
    n1 = ListNode(4)
    n2 = ListNode(5)
    n3 = ListNode(1)
    n4 = ListNode(9)

    n1.next = n2
    n2.next = n3
    n3.next = n4

    # Delete node with value 5 (node reference is given)
    delete_node(n2)

    curr = n1
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    # Output: 4 1 9
