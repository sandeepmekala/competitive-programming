# Problem: https://leetcode.com/problems/sum-of-two-integers/
# Idea: In binary addition, for 1,0 0,1 0,0 1,1 the sum will be 1,1,0,0. This we can get using xor.
# But 1,1 case generates a carry which needs to be added to next bit sum.
# When both are 1, the carry need to be 1. Hence use & to generate carry.
# But the carry need to be added to next bit. Hence right shift it by one bit.
# Repeate is until carry becomes 0.
def get_sum(a, b):
    MASK = 0xffffffff
    INT_MAX = 0x7fffffff

    while b != 0:
        carry = (a & b) & MASK
        a = (a ^ b) & MASK     # sum
        b = (carry << 1) & MASK  # carry after shifting

    return a if a <= INT_MAX else ~(a ^ MASK)


def get_diff(a, b):
    MASK = 0xffffffff
    INT_MAX = 0x7fffffff

    while b != 0:
        carry = ((~a) & b) & MASK
        a = (a ^ b) & MASK
        b = (carry << 1) & MASK

    return a if a <= INT_MAX else ~(a ^ MASK)


# ------------------ Test (Same as Java main) ------------------

print(get_sum(1, 2))   # Expected: 3
print(get_diff(1, 2))  # Expected: -1
