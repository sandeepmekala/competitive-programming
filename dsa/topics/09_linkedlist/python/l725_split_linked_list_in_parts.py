"""
Problem: https://leetcode.com/problems/split-linked-list-in-parts/

Idea:
Find part size.
Traverse the list, once list becomes of length of part size,
split it to make a new head and add new head to result.
Update part size as it can reduce if the remaining list length
becomes divisible by part size.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def split_list_to_parts(head: ListNode, k: int):
    length = get_length(head)

    result = [None] * k
    curr = head

    for i in range(k):
        if not curr:
            result[i] = None
            continue

        part_size = (length + k - i - 1) // (k - i)
        result[i] = curr

        # Move curr to the end of this part
        for _ in range(part_size - 1):
            curr = curr.next

        # Split
        next_part = curr.next
        curr.next = None
        curr = next_part

        length -= part_size

    return result


def get_length(head: ListNode) -> int:
    length = 0
    curr = head
    while curr:
        length += 1
        curr = curr.next
    return length


# Example usage
if __name__ == "__main__":
    # 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
    vals = list(range(1, 11))
    head = None
    curr = None

    for v in vals:
        node = ListNode(v)
        if not head:
            head = curr = node
        else:
            curr.next = node
            curr = curr.next

    parts = split_list_to_parts(head, 3)

    for i, part in enumerate(parts):
        print(f"Part {i+1}:", end=" ")
        p = part
        while p:
            print(p.val, end=" ")
            p = p.next
        print()
