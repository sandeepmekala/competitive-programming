# Problem: https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
# Idea: It is same as num of miss matching bits between to nums. Which is Hamming distance.
# Shift both start and goal bit by bit and check lsb's. If not matching, count.
def min_bit_flips(start, goal):
    count = 0
    for i in range(32):
        if ((start >> i) & 1) != ((goal >> i) & 1):
            count += 1
    return count


# ------------------ Test (Same as Java main) ------------------

print(min_bit_flips(10, 7))  # Expected: 3
