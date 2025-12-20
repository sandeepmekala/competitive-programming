"""
Idea:
Implement a queue using a singly linked list.
Maintain two pointers:
- front: for dequeue
- rear: for enqueue
Both operations work in O(1) time.
"""

class ListNode:
    def __init__(self, val, next=None):
        self.val = val
        self.next = next


class QueueUsingLinkedList:
    def __init__(self):
        self.front = None
        self.rear = None

    def enqueue(self, data):
        node = ListNode(data)

        if self.front is None and self.rear is None:
            self.front = self.rear = node
        else:
            self.rear.next = node
            self.rear = node

    def dequeue(self):
        if self.is_empty():
            return -1

        data = self.front.val

        if self.front == self.rear:
            self.front = self.rear = None
        else:
            self.front = self.front.next

        return data

    def is_empty(self):
        return self.front is None

    def print_queue(self):
        temp = self.front
        while temp:
            print(temp.val, end=" ")
            temp = temp.next
        print()


# Example usage
if __name__ == "__main__":
    queue = QueueUsingLinkedList()

    queue.enqueue(10)
    queue.enqueue(20)
    print("\nElements:")
    queue.print_queue()

    queue.dequeue()
    print("\nElements:")
    queue.print_queue()

    queue.dequeue()
    print("\nElements:")
    queue.print_queue()

    print(queue.is_empty())
