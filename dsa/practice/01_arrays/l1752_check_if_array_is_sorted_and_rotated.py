# L1752 - Check if Array Is Sorted and Rotated
#
# Problem: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/


def check(nums):
    n = len(nums)
    drops = 0

    for i in range(n):
        if nums[i] > nums[(i + 1) % n]:
            drops += 1
            if drops > 1:
                return False

    return True


# -------------------- TEST --------------------
if __name__ == "__main__":
    arr = [3, 4, 5, 1, 2]
    print(check(arr))   # True
