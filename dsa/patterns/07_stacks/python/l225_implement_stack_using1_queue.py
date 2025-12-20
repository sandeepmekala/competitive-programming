"""
Problem: https://leetcode.com/problems/implement-stack-using-queues/
Idea:
Use only one queue.
After pushing an element, rotate the queue by removing and adding
the first n-1 elements so that the newly added element comes to the front.
"""

from collections import deque

class MyStack:

    def __init__(self):
        self.queue = deque()

    def push(self, x: int) -> None:
        self.queue.append(x)

        # Move previous elements behind the new element
        for _ in range(len(self.queue) - 1):
            self.queue.append(self.queue.popleft())

    def pop(self) -> int:
        return self.queue.popleft()

    def top(self) -> int:
        return self.queue[0]

    def empty(self) -> bool:
        return not self.queue


# Example usage
if __name__ == "__main__":
    obj = MyStack()
    obj.push(1)
    obj.push(2)
    obj.push(3)
    print(obj.top())    # 3
    print(obj.pop())    # 3
    print(obj.empty())  # False
