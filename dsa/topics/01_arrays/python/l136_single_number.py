# L136 - Single Number
#
# Problem: https://leetcode.com/problems/single-number/
# Idea: XOR all the nums. All the duplicate nums will get nullified leaving only unique num.
# Time: O(n)
# Space: O(1)


def single_number(nums):
    res = 0
    for num in nums:
        res ^= num
    return res


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [2, 2, 1]
    print(single_number(nums))
