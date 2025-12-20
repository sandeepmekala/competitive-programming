# For negative numbers, the last bit is 1 which is sign bit
# For positive nums it is 0
# If we xor these 2 nums. result should be -ve if there are of opposite signs
def detect_two_numbers_with_opposite_signs(num1, num2):
    return (num1 ^ num2) < 0


# ------------------ Test (Same as Java main) ------------------

num1 = -1
num2 = 100
print(detect_two_numbers_with_opposite_signs(num1, num2))  # Expected: True
