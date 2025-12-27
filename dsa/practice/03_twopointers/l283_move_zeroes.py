# L283 - Move Zeroes
#
# Problem: https://leetcode.com/problems/move-zeroes/
#
# Idea:
# - Use two pointers
# - One pointer tracks the position to place the next non-zero
# - Swap when a non-zero is found
#
# Time: O(n)
# Space: O(1)


def move_zeroes(nums):
    l = 0  # position to place next non-zero

    for r in range(len(nums)):
        if nums[r] != 0:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [0, 1, 0, 3, 12]
    move_zeroes(nums)
    print(nums)  # Output: [1, 3, 12, 0, 0]
