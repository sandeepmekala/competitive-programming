# Problem: https://leetcode.com/problems/reverse-integer/
# Idea: Before right shifting res, check if multiplying it by 10 goes our of bound.
# res*10 > INT_MAX
# res > INT_MAX/10
def reverse(x):
    MAX = 2**31 - 1
    MIN = -2**31

    res = 0
    while x != 0:   # != 0 to handle negative nums also
        if res > MAX // 10:
            return 0
        if res < MIN // 10:
            return 0

        res = res * 10
        res = res + x % 10
        x = int(x / 10)   # truncate toward zero (Java-style)

    return res


# ------------------ Test (Same as Java main) ------------------

print(reverse(123))    # Expected: 321
print(reverse(-123))   # Expected: -321
