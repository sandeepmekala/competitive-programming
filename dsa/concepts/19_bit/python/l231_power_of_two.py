# Problem: https://leetcode.com/problems/power-of-two/
# Idea: pow of 2 always has only one 1 in bit wise representation
def is_power_of_two(n):
    if n == 0:
        return False

    while (n & 1) == 0:
        n = n >> 1

    return n == 1


# ------------------ Test (Same as Java main) ------------------

print(is_power_of_two(16))  # Expected: True
