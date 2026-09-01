# Problem: https://leetcode.com/problems/design-hashmap/
# Idea:
# Use an array of buckets (separate chaining).
# Each bucket stores (key, value) pairs in a list.
# Hash function maps key to bucket index.
# Time (avg): O(1) for put/get/remove, worst O(n)

class MyHashMap:
    def __init__(self):
        self.size = 100
        self.buckets = [[] for _ in range(self.size)]

    def put(self, key: int, value: int) -> None:
        ind = self._hash(key)
        bucket = self.buckets[ind]

        for i, (k, _) in enumerate(bucket):
            if k == key:
                bucket[i] = (key, value)   # update existing
                return

        bucket.append((key, value))         # insert new

    def get(self, key: int) -> int:
        ind = self._hash(key)
        bucket = self.buckets[ind]

        for k, v in bucket:
            if k == key:
                return v

        return -1

    def remove(self, key: int) -> None:
        ind = self._hash(key)
        bucket = self.buckets[ind]

        for i, (k, _) in enumerate(bucket):
            if k == key:
                bucket.pop(i)
                return

    def _hash(self, key: int) -> int:
        return key % self.size


# ------------------ Test (Same as Java main) ------------------

obj = MyHashMap()

obj.put(1, 1)
obj.put(2, 2)
print(obj.get(1))   # 1
print(obj.get(3))   # -1
obj.put(2, 1)
print(obj.get(2))   # 1
obj.remove(2)
print(obj.get(2))   # -1
