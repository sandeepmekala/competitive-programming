# Problem: https://leetcode.com/problems/string-to-integer-atoi/
# Companies: Amazon
# Idea: Use separate loops to check each condition. Track isPositive if it is -ve/+ve.
# Check num*10 goes above INT_MAX and also check num*10+s[i] goes above Integer range
# by inversing the match equation.
def my_atoi(s):
    if not s:
        return 0

    INT_MAX = 2**31 - 1
    INT_MIN = -2**31

    i = 0
    n = len(s)
    num = 0
    is_positive = True

    # ignoring whitespaces
    while i < n and s[i] == ' ':
        i += 1

    # checking for sign
    if i < n and (s[i] == '-' or s[i] == '+'):
        if s[i] == '-':
            is_positive = False
        i += 1

    # parsing digits
    while i < n and s[i].isdigit():
        int_val = ord(s[i]) - ord('0')

        # overflow check
        if num > INT_MAX // 10 or (num * 10) > INT_MAX - int_val:
            return INT_MAX if is_positive else INT_MIN

        num = num * 10 + int_val
        i += 1

    return num if is_positive else -num


# ------------------ Test (Same as Java main) ------------------

print(my_atoi("-42"))  # Expected: -42
