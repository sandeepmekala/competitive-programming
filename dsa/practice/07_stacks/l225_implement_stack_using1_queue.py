# Problem: https://leetcode.com/problems/implement-stack-using-queues/
#
# Idea:
# Use only one queue.
# After pushing an element, rotate the queue by removing and adding
# the first n-1 elements so that the newly added element comes to the front.

from collections import deque


class MyStack:
    def __init__(self) -> None:
        self.queue: deque[int] = deque()

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


# Driver code
if __name__ == "__main__":
    stack = MyStack()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    print(stack.top())    # 3
    print(stack.pop())    # 3
    print(stack.empty())  # False
