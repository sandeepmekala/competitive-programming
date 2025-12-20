"""
Problem: https://leetcode.com/problems/implement-queue-using-stacks/
Idea:
Use two stacks.
Approach shown here:
- Move all elements from stack1 to stack2
- Push new element to stack1
- Move everything back from stack2 to stack1
This ensures front of queue is always on top of stack1.

Alternative (Optimal):
Use input and output stacks to achieve O(1) amortized time.
"""

class MyQueue:
    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def push(self, x: int) -> None:
        # Move all elements to stack2
        while self.stack1:
            self.stack2.append(self.stack1.pop())

        # Push new element
        self.stack1.append(x)

        # Move back to stack1
        while self.stack2:
            self.stack1.append(self.stack2.pop())

    def pop(self) -> int:
        return self.stack1.pop()

    def peek(self) -> int:
        return self.stack1[-1]

    def empty(self) -> bool:
        return not self.stack1


# Example usage
if __name__ == "__main__":
    q = MyQueue()

    q.push(1)
    q.push(2)
    q.push(3)
    print(q.peek())   # 1
    print(q.pop())    # 1
    print(q.empty())  # False
