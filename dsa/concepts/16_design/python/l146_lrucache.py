# Problem: https://leetcode.com/problems/lru-cache/
# Idea:
# Use HashMap + Doubly Linked List
# - HashMap gives O(1) access to nodes
# - Doubly Linked List maintains usage order
#   * Most Recently Used (MRU) → near head
#   * Least Recently Used (LRU) → near tail
#
# get(key):
#   - If key exists, move node to head and return value
#
# put(key, value):
#   - If key exists, remove old node
#   - If capacity reached, evict LRU node (tail.prev)
#   - Insert new node at head
#
# Time: O(1) for get & put
# Space: O(capacity)

class LRUCache:

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.prev = None
            self.next = None

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}   # key -> Node

        # Dummy head and tail to avoid edge cases
        self.head = self.Node(0, 0)
        self.tail = self.Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1

        node = self.cache[key]
        self.remove(node)
        self.insert(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.remove(self.cache[key])

        if len(self.cache) == self.capacity:
            # Remove least recently used node
            self.remove(self.tail.prev)

        self.insert(self.Node(key, value))

    # Removes a node from both DLL and hashmap
    def remove(self, node):
        del self.cache[node.key]
        node.prev.next = node.next
        node.next.prev = node.prev

    # Inserts node right after head (most recently used)
    def insert(self, node):
        self.cache[node.key] = node
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node


# -------- Test (same flow as Java main) --------

obj = LRUCache(2)
obj.put(1, 1)
obj.put(2, 2)
print(obj.get(1))  # 1
obj.put(3, 3)
print(obj.get(2))  # -1
obj.put(4, 4)
print(obj.get(1))  # -1
print(obj.get(3))  # 3
print(obj.get(4))  # 4
