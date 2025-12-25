# L31 - Next Permutation
#
# Problem: https://leetcode.com/problems/next-permutation/
# Idea:
# 1. Find the rightmost index `i` such that nums[i] < nums[i + 1]
# 2. Find the smallest element greater than nums[i] to its right
# 3. Swap them
# 4. Reverse the suffix starting at i + 1
# 2, 1, 5, 4, 3 -> Everything after 5 is in decreasing order.
# 543 is largest after 1. We can't get any number greater then that. So, we have to increase 1 to next possible num.
#
# Time: O(n)
# Space: O(1)


def next_permutation(nums):
    n = len(nums)

    i = n - 2
    while i >= 0 and nums[i] >= nums[i + 1]:
        i -= 1                  # finds 2 in 2,3,1

    if i >= 0:
        j = n - 1
        while nums[j] <= nums[i]:
            j -= 1              # finds 3 in 2,3,1, which is greater then 2.
        nums[i], nums[j] = nums[j], nums[i]  # 2,3,1 -> 3,2,1

    l, r = i+1, n-1
    while (l < r):              # 3,2,1 -> 3,1,2
        nums[l], nums[r] = nums[r], nums[l]
        l += 1
        r -= 1


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 3, 2]
    next_permutation(nums)
    print(nums)
