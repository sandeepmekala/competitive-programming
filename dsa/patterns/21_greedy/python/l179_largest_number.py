from functools import cmp_to_key

# Problem: https://leetcode.com/problems/largest-number/
# Companies: Amazon
# Idea: Convert the nums to str and use str sorting

def largestNumber(nums):
    nums_str = list(map(str, nums))

    # Custom comparator: decide order by comparing concatenations
    def compare(a, b):
        if a + b > b + a:
            return -1
        if a + b < b + a:
            return 1
        return 0

    nums_str.sort(key=cmp_to_key(compare))

    # Edge case: when all numbers are zero
    if nums_str[0] == "0":
        return "0"

    return "".join(nums_str)


# -------- Test --------
print(largestNumber([3, 30, 34, 5, 9]))  # Expected: "9534330"
