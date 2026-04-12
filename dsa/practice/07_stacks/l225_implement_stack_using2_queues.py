# Problem: https://leetcode.com/problems/implement-stack-using-queues/
#
# Idea:
# Use two queues.
# Before inserting a new element, move all elements from queue1 to queue2.
# Push the new element into queue1.
# Move everything back from queue2 to queue1 so that the newest element
# always stays at the front of queue1.

from collections import deque


class MyStack:
    def __init__(self) -> None:
        self.q1: deque[int] = deque()
        self.q2: deque[int] = deque()

    def push(self, x: int) -> None:
        # Move all elements to q2
        while self.q1:
            self.q2.append(self.q1.popleft())

        # Push new element to q1
        self.q1.append(x)

        # Move everything back to q1
        while self.q2:
            self.q1.append(self.q2.popleft())

    def pop(self) -> int:
        return self.q1.popleft()

    def top(self) -> int:
        return self.q1[0]

    def empty(self) -> bool:
        return not self.q1


# Driver code
if __name__ == "__main__":
    stack = MyStack()
    stack.push(1)
    stack.push(2)
    print(stack.top())    # 2
    print(stack.pop())    # 2
    print(stack.empty())  # False
