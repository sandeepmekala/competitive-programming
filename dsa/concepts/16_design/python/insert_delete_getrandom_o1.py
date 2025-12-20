import random

# Problem: https://leetcode.com/problems/insert-delete-getrandom-o1/
# Companies: Amazon
class InsertDeleteGetRandomO1:

    def __init__(self):
        self.map = {}          # val -> index in list
        self.list = []         # stores values
        self.rand = random.Random()

    # Idea:
    # If val is not present, add it to the end of list
    # Store its index in map
    # Time: O(1)
    def insert(self, val: int) -> bool:
        if val not in self.map:
            self.map[val] = len(self.list)
            self.list.append(val)
            return True
        return False

    # Idea:
    # To delete in O(1), swap the element to remove with the last element
    # Update index of swapped element in map
    # Remove last element from list and delete from map
    # Time: O(1)
    def remove(self, val: int) -> bool:
        if val in self.map:
            idx = self.map[val]
            last_val = self.list[-1]

            if idx < len(self.list) - 1:
                self.list[idx] = last_val
                self.map[last_val] = idx

            self.list.pop()
            del self.map[val]
            return True
        return False

    # Idea:
    # Pick a random index from list
    # Time: O(1)
    def getRandom(self) -> int:
        return self.list[self.rand.randint(0, len(self.list) - 1)]


# ------------------ Test (Same as Java main) ------------------

obj = InsertDeleteGetRandomO1()
print(obj.insert(1))     # True
print(obj.remove(2))     # False
print(obj.insert(2))     # True
print(obj.getRandom())   # 1 or 2
print(obj.remove(1))     # True
print(obj.insert(2))     # False
print(obj.getRandom())   # 2
