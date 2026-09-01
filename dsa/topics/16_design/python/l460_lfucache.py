# Problem: https://leetcode.com/problems/lfu-cache/
# Idea:
# LFU = Least Frequently Used
#
# Data Structures:
# 1) cache        : key -> DLLNode
# 2) freqMap      : frequency -> DoubleLinkedList (nodes with same frequency)
# 3) minFreq      : minimum frequency currently present
#
# get(key):
#   - If not present, return -1
#   - Update node frequency
#
# put(key, value):
#   - If key exists, update value and frequency
#   - Else insert new node
#   - If capacity exceeded, evict LRU node from minFreq list
#
# Time Complexity: O(1) for get and put
# Space Complexity: O(capacity)

class LFUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.curSize = 0
        self.minFreq = 0

        self.cache = {}      # key -> DLLNode
        self.freqMap = {}    # freq -> DoubleLinkedList

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1

        node = self.cache[key]
        self.updateNode(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if self.capacity == 0:
            return

        if key in self.cache:
            node = self.cache[key]
            node.val = value
            self.updateNode(node)
        else:
            self.curSize += 1

            if self.curSize > self.capacity:
                # Remove LRU node from the minimum frequency list
                minFreqList = self.freqMap[self.minFreq]
                lruNode = minFreqList.tail.prev
                minFreqList.removeNode(lruNode)
                del self.cache[lruNode.key]
                self.curSize -= 1

            # Insert new node with frequency = 1
            self.minFreq = 1
            newNode = DLLNode(key, value)

            freqList = self.freqMap.get(1, DoubleLinkedList())
            freqList.addNode(newNode)
            self.freqMap[1] = freqList
            self.cache[key] = newNode

    def updateNode(self, node):
        curFreq = node.frequency
        curList = self.freqMap[curFreq]
        curList.removeNode(node)

        # If this was the only node with minFreq, increase minFreq
        if curFreq == self.minFreq and curList.listSize == 0:
            self.minFreq += 1

        node.frequency += 1
        newList = self.freqMap.get(node.frequency, DoubleLinkedList())
        newList.addNode(node)
        self.freqMap[node.frequency] = newList


class DLLNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.frequency = 1
        self.prev = None
        self.next = None


class DoubleLinkedList:
    def __init__(self):
        self.listSize = 0
        self.head = DLLNode(0, 0)
        self.tail = DLLNode(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def addNode(self, node):
        nextNode = self.head.next
        node.next = nextNode
        node.prev = self.head
        self.head.next = node
        nextNode.prev = node
        self.listSize += 1

    def removeNode(self, node):
        prevNode = node.prev
        nextNode = node.next
        prevNode.next = nextNode
        nextNode.prev = prevNode
        self.listSize -= 1
