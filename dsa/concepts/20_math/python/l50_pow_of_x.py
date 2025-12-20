# Problem: https://leetcode.com/problems/powx-n/
# x^n
# Idea: 2^4 = 2^(4/2) * 2^(4/2)
# 2^5 = 2^(5/2) * 2^(5/2) * 2^1
# 2^0 = 1
# 2^-3 = 1/2^3
def my_pow(x, n):
    if n >= 0:
        return pow_util(x, n)
    else:
        return 1 / pow_util(x, -n)


# Time: O(logn)
def pow_util(x, n):
    if n == 0:
        return 1

    temp = pow_util(x, n // 2)
    if n % 2 == 0:
        return temp * temp      # if power is even
    else:
        return x * temp * temp  # if power is odd


# ------------------ Test (Same as Java main) ------------------

x = 2
n = -3
print(my_pow(x, n))   # Expected: 0.125
