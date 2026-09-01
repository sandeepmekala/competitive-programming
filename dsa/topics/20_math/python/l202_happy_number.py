# Problem: https://leetcode.com/problems/happy-number/
# Idea: Run the while loop until n becomes 1 or you get into a cycle i.e generating old n again.
# We can use Floyd's cycle detection algo to find the cycle.
def is_happy(n):
    slow = n
    fast = n

    while True:
        slow = get_sum_of_squares(slow)
        fast = get_sum_of_squares(get_sum_of_squares(fast))

        if fast == 1:
            return True
        if slow == fast:
            break

    return False


def get_sum_of_squares(n):
    num = 0
    while n > 0:
        digit = n % 10
        num += digit * digit
        n = n // 10
    return num


# ------------------ Test (Same as Java main) ------------------

print(is_happy(19))  # Expected: True
