"""
Problem: https://leetcode.com/problems/implement-stack-using-queues/
Idea:
Use two queues.
Before inserting a new element, move all elements from queue1 to queue2.
Push the new element into queue1.
Move everything back from queue2 to queue1 so that the newest element
always stays at the front of queue1.
"""

from collections import deque

class MyStack:

    def __init__(self):
        self.q1 = deque()
        self.q2 = deque()

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


# Example usage
if __name__ == "__main__":
    obj = MyStack()
    obj.push(1)
    obj.push(2)
    print(obj.top())    # 2
    print(obj.pop())    # 2
    print(obj.empty())  # False
