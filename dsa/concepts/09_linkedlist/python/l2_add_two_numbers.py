"""
Problem: https://leetcode.com/problems/add-two-numbers/
Idea:
Use the same technique as normal number addition.
Traverse both linked lists, add corresponding digits along with carry,
and build the result list.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def add_two_numbers(l1: ListNode, l2: ListNode) -> ListNode:
    dummy = ListNode(0)
    curr = dummy
    carry = 0

    while l1 or l2 or carry:
        val1 = l1.val if l1 else 0
        val2 = l2.val if l2 else 0

        total = val1 + val2 + carry
        carry = total // 10

        curr.next = ListNode(total % 10)
        curr = curr.next

        if l1:
            l1 = l1.next
        if l2:
            l2 = l2.next

    return dummy.next


# Example usage
if __name__ == "__main__":
    # First number: 342 (stored as 2 -> 4 -> 3)
    l1 = ListNode(2, ListNode(4, ListNode(3)))

    # Second number: 465 (stored as 5 -> 6 -> 4)
    l2 = ListNode(5, ListNode(6, ListNode(4)))

    result = add_two_numbers(l1, l2)

    # Print result: 807 -> 7 -> 0 -> 8
    while result:
        print(result.val, end=" ")
        result = result.next
