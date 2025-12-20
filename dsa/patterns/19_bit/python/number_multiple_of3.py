# Problem: https://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-is-multiple-of-3/
# Idea: In decimal form this number will be:  2^{4} * a  +  2^{3} * b  +  2^{2} * c  +  2^{1} * d  +  2^{0} * e
# Every even power of 2 can be represented as 3n + 1, and every odd power of 2 can be represented as 3n – 1.
# term (a + c + e) - (b + d) should be divisible by 3 if we take 3n out
def is_multiple_of_3(n):
    if n < 0:
        n = -n

    if n == 0:
        return True
    if n == 1 or n == 2:
        return False

    odd_bit_count = 0
    even_bit_count = 0

    while n != 0:
        if (n & 1) == 1:
            odd_bit_count += 1
        n = n >> 1

        if (n & 1) == 1:
            even_bit_count += 1
        n = n >> 1

    return is_multiple_of_3(odd_bit_count - even_bit_count)


# ------------------ Test (Same as Java main) ------------------

n = 7
print(is_multiple_of_3(n))  # Expected: False
