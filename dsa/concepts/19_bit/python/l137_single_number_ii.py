# Problem: https://leetcode.com/problems/single-number-ii/
# Idea: Count the number of 1's and do %3. It will nullify all the repeating nums leaving the odd bit.
# Time: O(n), Space: O(1)
def single_number(nums):
    ans = 0
    for i in range(32):
        bits = 0
        for num in nums:
            if ((num >> i) & 1) == 1:
                bits += 1
        if bits % 3 != 0:
            ans |= (1 << i)

    # handle negative numbers (32-bit signed)
    if ans >= 2**31:
        ans -= 2**32

    return ans


# Idea: num will go to ones if it is not in twos.
# num will go to twos if it is in ones.
# num will go to threes if it is in twos.
def single_number2(nums):
    ones = 0
    twos = 0
    for num in nums:
        ones = (ones ^ num) & ~twos
        twos = (twos ^ num) & ~ones
    return ones


# ------------------ Test (Same as Java main) ------------------

numbers = [1, 5, 3, 5, 1, 5, 1]
print(single_number(numbers))   # Expected: 3
print(single_number2(numbers))  # Expected: 3
