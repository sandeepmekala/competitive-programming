# Problem: https://leetcode.com/problems/counting-bits/
# Idea: If a number is even, if we shift it right, bit 0 will go and remaining number is half of it.
# If a num if odd, it will have 1 at lsb. Hence add 1 and shift it right.
#
# 101 -> f(10) + 1
# 110 -> f(11) + 0
# Time: O(n)
def count_bits(n):
    count = [0] * (n + 1)
    for i in range(1, n + 1):
        count[i] = count[i >> 1] + (i & 1)
    return count


# ------------------ Test (Same as Java main) ------------------

print(count_bits(3))  # Expected: [0, 1, 1, 2]
