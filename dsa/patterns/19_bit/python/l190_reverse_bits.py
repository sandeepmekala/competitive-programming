# Problem: https://leetcode.com/problems/reverse-bits/
# Idea: Take lsb of n and |(or) it with res and shift res to right.
# Repeat this for 32 times.
def reverse_bits(n):
    res = 0
    n = n & 0xffffffff   # handle 32-bit unsigned behavior

    for i in range(32):
        res = res << 1
        res = res | ((n >> i) & 1)

    return res & 0xffffffff


# ------------------ Test (Same as Java main) ------------------

num = 43261596
print("binary:", bin(num)[2:])
print("reverse:", bin(reverse_bits(num))[2:])
