# Problem: https://leetcode.com/problems/add-digits/
# Companies: Microsoft
# Idea: If a num is divisible by 9, then sum of its digits also will be devisible by 9.
# Final single digit number will be 1-9 after executing this algo.
# Hence, instead of summing digits, we can check num divisibility by 9.
# If it is divisible by 9, then single digit will be 9, else it will be remainder after deviding it by 9.
def add_digits(num):
    if num == 0:
        return 0

    if num % 9 == 0:
        return 9
    else:
        return num % 9


def add_digits2(num):
    while True:
        if num < 10:
            return num

        s = 0
        while num > 0:
            reminder = num % 10
            s += reminder
            num = num // 10

        num = s


# ------------------ Test (Same as Java main) ------------------

print(add_digits(123))   # Expected: 6
print(add_digits2(123))  # Expected: 6
