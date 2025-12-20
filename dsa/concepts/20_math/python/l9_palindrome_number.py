# Problem: https://leetcode.com/problems/palindrome-number/
# Idea: Calculate reverse number by take rem each time and compare num and rev num.
def is_palindrome(x):
    if x < 0:
        return False

    num = x
    rev = 0
    while x > 0:
        rev = rev * 10
        rev += x % 10
        x = x // 10

    return num == rev


# ------------------ Test (Same as Java main) ------------------

print(is_palindrome(121))   # Expected: True
