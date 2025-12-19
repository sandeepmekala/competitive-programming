"""
Problem: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

Idea:
Head is MSB. We have to start evaluation from LSB.
Hence, use recursive approach.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def __init__(self):
        self.pow = 0

    def getDecimalValue(self, head: ListNode) -> int:
        if not head:
            return 0

        # Go till the end (LSB)
        total = self.getDecimalValue(head.next)

        # Add current bit contribution
        total += head.val * (1 << self.pow)
        self.pow += 1

        return total


# Example usage
if __name__ == "__main__":
    # 0 -> 1 -> 1  (binary 011 = decimal 3)
    head = ListNode(0, ListNode(1, ListNode(1)))

    sol = Solution()
    print(sol.getDecimalValue(head))  # 3
