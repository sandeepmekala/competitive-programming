"""
Problem: https://leetcode.com/problems/copy-list-with-random-pointer/

Idea:
Use map to store the mapping between node and its copy.
In first pass create copies of each node and store.
In second pass, get the copy of each node and adjust its next and random pointers.

You can solve it inplace by following 3 steps below:
    1. Insert copy nodes next to their original nodes.
    2. Then create random pointers.
    3. Then change next pointers.
"""

class Node:
    def __init__(self, val: int, next=None, random=None):
        self.val = val
        self.next = next
        self.random = random


def copy_random_list(head: Node) -> Node:
    if not head:
        return None

    node_map = {}

    # First pass: create copy of each node
    curr = head
    while curr:
        node_map[curr] = Node(curr.val)
        curr = curr.next

    # Second pass: assign next and random pointers
    curr = head
    while curr:
        copy = node_map[curr]
        copy.next = node_map.get(curr.next)
        copy.random = node_map.get(curr.random)
        curr = curr.next

    return node_map[head]


# Example usage (simple next-only list)
if __name__ == "__main__":
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)

    n1.next = n2
    n2.next = n3

    n1.random = n3
    n2.random = n1
    n3.random = n2

    copied_head = copy_random_list(n1)

    curr = copied_head
    while curr:
        rand_val = curr.random.val if curr.random else None
        print(f"Node: {curr.val}, Random: {rand_val}")
        curr = curr.next
