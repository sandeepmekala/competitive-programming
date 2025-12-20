# Problem: https://leetcode.com/problems/time-based-key-value-store/
# Idea:
# Store for each key a list of (value, timestamp) pairs in increasing timestamp order.
# For get(), use Binary Search to find the value with the largest timestamp <= given timestamp.
#
# set  -> O(1)
# get  -> O(log n)
# Space -> O(n)

class TimeMap:

    def __init__(self):
        # key -> list of (value, timestamp)
        self.map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        self.map[key].append((value, timestamp))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.map:
            return ""

        values = self.map[key]
        low, high = 0, len(values) - 1
        res = ""

        # Binary search for closest time <= timestamp
        while low <= high:
            mid = (low + high) // 2
            val, time = values[mid]

            if time <= timestamp:
                res = val
                low = mid + 1
            else:
                high = mid - 1

        return res


# ---------------- Test (same as Java main) ----------------

obj = TimeMap()

obj.set("foo", "bar", 1)
print(obj.get("foo", 1))   # bar
print(obj.get("foo", 3))   # bar
obj.set("foo", "bar2", 4)
print(obj.get("foo", 4))   # bar2
print(obj.get("foo", 5))   # bar2
