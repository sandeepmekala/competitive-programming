import random

class ShuffleAnArray:
    def __init__(self, nums):
        self.nums = nums


    # Problem: https://leetcode.com/problems/shuffle-an-array/
    # Companies: Amazon
    # Idea: Clone the array in shuffle function and use random to generate radome
    # indices and place each element of array.
    def reset(self):
        return self.nums


    def shuffle(self):
        shuffled = self.nums[:]   # clone array
        n = len(shuffled)

        for i in range(n):
            rand_ind = random.randint(0, i)
            shuffled[i], shuffled[rand_ind] = shuffled[rand_ind], shuffled[i]

        return shuffled


# ------------------ Test (Same as Java main) ------------------

obj = ShuffleAnArray([1, 2, 3, 4, 5])

print(obj.shuffle())
print(obj.reset())
