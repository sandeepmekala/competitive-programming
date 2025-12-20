"""
Idea:
Implement a stack using a singly linked list.
Push and pop operations happen at the head of the list.
The head pointer represents the top of the stack.
"""

class ListNode:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


class StackUsingLinkedList:
    def __init__(self):
        self.top_node = None

    def push(self, data):
        node = ListNode(data)
        node.next = self.top_node
        self.top_node = node

    def pop(self):
        if self.top_node is None:
            print("Stack is empty")
            return
        self.top_node = self.top_node.next

    def top(self):
        if self.top_node is None:
            print("Stack is empty")
            return -1
        return self.top_node.val

    def is_empty(self):
        return self.top_node is None

    def print_stack(self):
        if self.top_node is None:
            print("Stack is empty")
            return

        temp = self.top_node
        while temp:
            print(temp.val, end=" ")
            temp = temp.next
        print()


# Example usage
if __name__ == "__main__":
    stack = StackUsingLinkedList()

    stack.push(10)
    stack.print_stack()
    stack.push(20)
    stack.print_stack()
    stack.push(30)
    stack.print_stack()
    stack.pop()
    stack.print_stack()
    print("\nPrinting top element:")
    print(stack.top())
    stack.print_stack()
    print("\nChecking if stack is empty:")
    print(stack.is_empty())
