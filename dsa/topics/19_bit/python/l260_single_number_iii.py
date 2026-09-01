# Problem: https://leetcode.com/problems/single-number-iii/
# Idea: XOR all numbers to get xor of two numbers. Find rightmost set bit in xor to seperate two number based on that bit into 2 buckets.
# This bit is always different for two nums.
# Separate all nums to two buckets based on this bit. Duplicate nums will go to same bucket.
# XOR all nums in bucket to cancel duplicate nums and get single nums;
# Time: O(n), Space: O(1)
def single_number(nums):
    # XOR all numbers to get xor of the two unique numbers
    xor = 0
    for num in nums:
        xor ^= num

    # Find the rightmost set bit
    right_most = (xor & (xor - 1)) ^ xor

    b1 = 0
    b2 = 0
    for num in nums:
        if (num & right_most) > 0:
            b1 ^= num
        else:
            b2 ^= num

    return [b1, b2]


# ------------------ Test (Same as Java main) ------------------

nums = [1, 2, 1, 3, 2, 5]
res = single_number(nums)
print(res[0], res[1])  # Expected: 3 5 (order may vary)
