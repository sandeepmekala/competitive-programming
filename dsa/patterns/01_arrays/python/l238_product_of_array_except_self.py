# L238 - Product of Array Except Self
#
# Problem: https://leetcode.com/problems/product-of-array-except-self/
# Idea: Track prefix and suffix products. Result is prefix_prod * suffix_prod.
# Time: O(n)
# Space: O(1) - excluding the output array


def product_except_self(nums):
    n = len(nums)
    res = [1] * n

    pref_prod = 1
    for i in range(n):
        res[i] = pref_prod
        pref_prod *= nums[i]

    suf_prod = 1
    for i in range(n-1, -1, -1):
        res[i] *= suf_prod
        suf_prod *= nums[i]

    return res


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 2, 3, 4]
    print(product_except_self(nums))  # [24, 12, 8, 6]
