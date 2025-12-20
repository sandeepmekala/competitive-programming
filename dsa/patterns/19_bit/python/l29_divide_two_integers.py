# Problem: https://leetcode.com/problems/divide-two-integers/
# Idea: Instead of subtracting divisor from dividend one at a time, subtract divisor in multiple of 2^n.
# This will reduce the time complexity to log(n) from n.
# For f(22, 3) => 3*7 = 21, 3*(2^2+2^1+2^0)
# Time: O(log(n)^2), Space: O(1)
def divide(dividend, divisor):
    INT_MAX = 2**31 - 1
    INT_MIN = -2**31

    if dividend == divisor:
        return 1

    # Corner case when -2^31 is divided by -1
    if dividend == INT_MIN and divisor == -1:
        return INT_MAX

    negative = (dividend < 0) ^ (divisor < 0)

    dividend = abs(dividend)
    divisor = abs(divisor)

    quotient = 0
    while dividend - divisor >= 0:
        cnt = 0
        while dividend - (divisor << (cnt + 1)) >= 0:
            cnt += 1

        quotient += 1 << cnt
        dividend -= divisor << cnt

    return -quotient if negative else quotient


# ------------------ Test (Same as Java main) ------------------

print(divide(22, 3))   # Expected: 7
print(divide(7, -3))   # Expected: -2
