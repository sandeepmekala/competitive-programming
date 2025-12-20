"""
Idea:
Implement a doubly linked list.
- Insert nodes before head
- Reverse the doubly linked list by swapping prev and next pointers
"""

class ListNode:
    def __init__(self, val):
        self.val = val
        self.prev = None
        self.next = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def insert_before_head(self, data):
        node = ListNode(data)
        if self.head is None:
            self.head = node
            return

        self.head.prev = node
        node.next = self.head
        self.head = node

    def reverse(self, head):
        if head is None or head.next is None:
            return head

        curr = head
        prev = None

        while curr:
            # swap prev and next
            prev = curr.prev
            curr.prev = curr.next
            curr.next = prev

            # move to "next" node (which is prev after swap)
            curr = curr.prev

        # prev is at second last node, so return prev.prev
        return prev.prev

    def print_list(self):
        if self.head is None:
            print("List is empty")
            return

        curr = self.head
        while curr:
            print(curr.val, end=" ")
            curr = curr.next
        print()


# Example usage
if __name__ == "__main__":
    dll = DoublyLinkedList()

    dll.insert_before_head(10)
    dll.insert_before_head(20)
    dll.insert_before_head(30)
    dll.print_list()

    print("Reverse:")
    dll.head = dll.reverse(dll.head)
    dll.print_list()
