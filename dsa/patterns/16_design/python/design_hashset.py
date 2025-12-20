# Problem: https://leetcode.com/problems/design-hashset/
# Idea:
# Use an array of buckets (separate chaining).
# Each bucket stores keys in a list.
# Hash function maps key to bucket index.
# Time (avg): O(1) for add/remove/contains, worst O(n)

class MyHashSet:
    def __init__(self):
        self.size = 100
        self.buckets = [[] for _ in range(self.size)]

    def add(self, key: int) -> None:
        ind = self._hash(key)
        bucket = self.buckets[ind]

        if key in bucket:
            return
        bucket.append(key)

    def remove(self, key: int) -> None:
        ind = self._hash(key)
        bucket = self.buckets[ind]

        if key in bucket:
            bucket.remove(key)

    def contains(self, key: int) -> bool:
        ind = self._hash(key)
        return key in self.buckets[ind]

    def _hash(self, key: int) -> int:
        return key % self.size


# ------------------ Test (Same as Java main) ------------------

obj = MyHashSet()

obj.add(1)
obj.add(2)
print(obj.contains(1))   # True
print(obj.contains(3))   # False
obj.add(2)
print(obj.contains(2))   # True
obj.remove(2)
print(obj.contains(2))   # False
