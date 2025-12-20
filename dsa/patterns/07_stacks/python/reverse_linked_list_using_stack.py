"""
Idea:
Reverse a singly linked list using a stack.
Push all nodes to a stack, then pop them one by one
and reconnect pointers in reverse order.
"""

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class SinglyLinkedList:
    def __init__(self):
        self.head = None

    def insert_after_end(self, val):
        if not self.head:
            self.head = ListNode(val)
            return
        curr = self.head
        while curr.next:
            curr = curr.next
        curr.next = ListNode(val)

    def print_list(self):
        curr = self.head
        while curr:
            print(curr.val, end=" -> ")
            curr = curr.next
        print("None")


def reverse_linked_list_using_stack(sll: SinglyLinkedList):
    stack = []

    temp = sll.head
    while temp:
        stack.append(temp)
        temp = temp.next

    # New head
    sll.head = stack.pop()
    curr = sll.head

    while stack:
        curr.next = stack.pop()
        curr = curr.next

    curr.next = None


# Example usage
if __name__ == "__main__":
    sll = SinglyLinkedList()
    sll.insert_after_end(10)
    sll.insert_after_end(20)
    sll.insert_after_end(30)

    sll.print_list()
    reverse_linked_list_using_stack(sll)
    sll.print_list()
