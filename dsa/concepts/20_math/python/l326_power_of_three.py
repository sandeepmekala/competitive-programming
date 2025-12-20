# Problem: https://leetcode.com/problems/power-of-three/
# Idea: Divid the n in while loop until it becomes 1, if it doesn't become 1 return false.
def is_power_of_three(n):
    while n > 0 and n % 3 == 0:
        n = n // 3

    return n == 1


# ------------------ Test (Same as Java main) ------------------

print(is_power_of_three(45))  # Expected: False
