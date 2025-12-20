# Problem: https://leetcode.com/problems/plus-one/
# Idea: In 999 case carry could propagate from right to left. Hence, process right to left.
def plus_one(digits):
    result = []
    carry = 1
    n = len(digits)

    for i in range(n - 1, -1, -1):
        s = carry + digits[i]
        result.append(s % 10)
        carry = s // 10

    if carry > 0:
        result.append(carry)

    result.reverse()
    return result


# ------------------ Test (Same as Java main) ------------------

print(plus_one([1, 2, 3]))  # Expected: [1, 2, 4]
