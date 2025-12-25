# L2149 - Rearrange Array Elements by Sign
#
# Problem: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
# Idea: Traverse the array and put positive numbers at even index and negative numbers at odd index.


def rearrange_array(nums):
    n = len(nums)
    result = [0] * n

    pos_idx, neg_idx = 0, 1

    for num in nums:
        if num >= 0:
            result[pos_idx] = num
            pos_idx += 2
        else:
            result[neg_idx] = num
            neg_idx += 2

    return result


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [-1, 2, 3, -4, -1, 4]
    print(rearrange_array(nums))
