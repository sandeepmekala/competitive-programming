# L268 - Missing Number
#
# Problem: https://leetcode.com/problems/missing-number/
# Idea: a ^ b ^ b = a


def missing_number(nums):
    n = len(nums)
    res = 0

    for i in range(n+1):
        res ^= i
        if i < n:
            res ^= nums[i]

    return res


# -------------------- TEST --------------------
if __name__ == "__main__":
    print(missing_number([3, 0, 1]))  # 2
