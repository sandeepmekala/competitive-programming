class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class SingleLinkedList:

    def __init__(self):
        self.head = None

    def insertAfterEnd(self, data):
        if self.head is None:
            self.head = ListNode(data)
            return

        temp = self.head
        while temp.next:
            temp = temp.next
        temp.next = ListNode(data)

    def insertBeforeHead(self, data):
        node = ListNode(data)
        node.next = self.head
        self.head = node

    def print(self):
        if self.head is None:
            print("List is empty")
            return

        temp = self.head
        while temp:
            print(temp.val, end=" ")
            temp = temp.next
        print()

    def insertAtKthPosition(self, data, k):
        node = ListNode(data)

        if k == 1:
            node.next = self.head
            self.head = node
            return

        temp = self.head
        for _ in range(k - 2):
            temp = temp.next

        node.next = temp.next
        temp.next = node

    def deleteAtKthPosition(self, k):
        if self.head is None:
            return

        if k == 1:
            self.head = self.head.next
            return

        temp = self.head
        for _ in range(k - 2):
            temp = temp.next

        temp.next = temp.next.next

    def reverse(self):
        prev = None
        curr = self.head

        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node

        self.head = prev

    def printRec(self, node):
        if node is None:
            return
        print(node.val, end=" ")
        self.printRec(node.next)

    def reversePrintRec(self, node):
        if node is None:
            return
        self.reversePrintRec(node.next)
        print(node.val, end=" ")

    def size(self):
        count = 0
        curr = self.head
        while curr:
            count += 1
            curr = curr.next
        return count


# Demo (same flow as Java main)
if __name__ == "__main__":
    sll = SingleLinkedList()

    sll.print()
    sll.insertAfterEnd(10)
    sll.print()

    sll.insertAfterEnd(20)
    sll.insertAfterEnd(30)
    sll.print()

    sll.insertBeforeHead(40)
    sll.print()

    sll.insertBeforeHead(50)
    sll.print()

    sll.insertAtKthPosition(60, 1)
    sll.insertAtKthPosition(70, 2)
    sll.insertAtKthPosition(80, 3)
    sll.print()

    sll.deleteAtKthPosition(1)
    sll.print()

    sll.reverse()
    sll.print()
