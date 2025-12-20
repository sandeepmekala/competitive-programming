"""
Problem: https://leetcode.com/problems/min-stack/
Idea:
Use two stacks.
One stack supports normal stack operations (push, pop, top).
The second stack keeps track of the minimum value till each element.
While pushing, store min(current_value, current_min) in the min stack.
"""

class MinStack:

    def __init__(self):
        self.stack = []
        self.min_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)

        if not self.min_stack:
            self.min_stack.append(val)
        else:
            self.min_stack.append(min(val, self.min_stack[-1]))

    def pop(self) -> None:
        self.stack.pop()
        self.min_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def get_min(self) -> int:
        return self.min_stack[-1]


# Example usage
if __name__ == "__main__":
    obj = MinStack()
    obj.push(-2)
    obj.push(0)
    obj.push(-3)
    print(obj.get_min())  # -3
    obj.pop()
    print(obj.top())      # 0
    print(obj.get_min())  # -2
