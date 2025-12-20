# Problem: https://leetcode.com/problems/number-of-1-bits/
# Idea: Loop through 32 bits and check whether it is set or not.
def hamming_weight(n):
    count = 0
    n = n & 0xffffffff   # ensure 32-bit behavior

    for i in range(32):
        if ((n >> i) & 1) > 0:
            count += 1

    return count


# ------------------ Test (Same as Java main) ------------------

print(hamming_weight(3))  # Expected: 2
