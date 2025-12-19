"""
Idea:
Implement a queue using a circular array.
Use front and rear pointers.
- Enqueue at rear
- Dequeue from front
- Use modulo (%) to reuse empty spaces
"""

class QueueUsingArray:
    def __init__(self, max_size=10):
        self.max_size = max_size
        self.elements = [0] * max_size
        self.front = -1
        self.rear = -1

    def enqueue(self, data):
        if self.is_full():
            print("Queue Overflow")
            return

        if self.front == -1 and self.rear == -1:
            self.front = self.rear = 0
        else:
            self.rear = (self.rear + 1) % self.max_size

        self.elements[self.rear] = data

    def dequeue(self):
        if self.is_empty():
            print("Queue Underflow")
            return -1

        data = self.elements[self.front]

        if self.front == self.rear:
            self.front = self.rear = -1
        else:
            self.front = (self.front + 1) % self.max_size

        return data

    def peek(self):
        if self.is_empty():
            print("Queue Underflow")
            return -1
        return self.elements[self.front]

    def is_empty(self):
        return self.front == -1 and self.rear == -1

    def is_full(self):
        return (self.rear + 1) % self.max_size == self.front

    def print_queue(self):
        if self.is_empty():
            print("Queue Underflow")
            return
        print(self.elements)


# Example usage
if __name__ == "__main__":
    queue = QueueUsingArray()

    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)
    queue.enqueue(40)
    queue.enqueue(50)
    queue.enqueue(60)
    queue.enqueue(70)
    queue.enqueue(80)
    queue.enqueue(90)
    queue.enqueue(100)
    queue.enqueue(110)   # overflow

    print("\nElements:")
    queue.print_queue()

    print("\nDequeue:")
    print(queue.dequeue())

    print("\nElements:")
    queue.print_queue()

    queue.enqueue(110)

    print("\nElements:")
    queue.print_queue()

    print("\nPeek:")
    print(queue.peek())
