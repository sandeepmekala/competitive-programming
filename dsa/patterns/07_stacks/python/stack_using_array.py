"""
Idea:
Implement a stack using an array.
Maintain a `top` pointer to track the top element.
Support push, pop, top, is_empty, and print operations.
"""

class StackUsingArray:
    def __init__(self, max_size=101):
        self.max_size = max_size
        self.elements = [0] * max_size
        self.top_index = -1

    def push(self, data):
        if self.top_index == self.max_size - 1:
            print("Error: Stack Overflow")
            return
        self.top_index += 1
        self.elements[self.top_index] = data

    def pop(self):
        if self.top_index == -1:
            print("Error: Stack Underflows")
            return
        self.top_index -= 1

    def top(self):
        if self.top_index == -1:
            print("Error: Stack Underflows")
            return -1
        return self.elements[self.top_index]

    def is_empty(self):
        if self.top_index == -1:
            print("Stack is empty")
            return True
        return False

    def print_stack(self):
        print()
        for i in range(self.top_index + 1):
            print(self.elements[i], end=" ")
        print()


# Example usage
if __name__ == "__main__":
    stack = StackUsingArray()

    stack.push(10)
    stack.print_stack()
    stack.push(20)
    stack.print_stack()
    stack.push(30)
    stack.print_stack()
    stack.pop()
    stack.print_stack()
    print("\n", stack.top())
    stack.print_stack()
    stack.is_empty()
