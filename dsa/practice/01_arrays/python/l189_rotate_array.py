# L189 - Rotate Array
#
# Problem: https://leetcode.com/problems/rotate-array/
# Idea: Reverse entire array, then reverse first k and n-k element sub arrays
# Time: O(n)
# Space: O(1)


def rotate(nums, k):
    n = len(nums)
    k %= n  # Handle k > n

    def reverse(left, right):
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1

    # Reverse entire array
    reverse(0, n - 1)
    # Reverse first k elements
    reverse(0, k - 1)
    # Reverse remaining elements
    reverse(k, n - 1)


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3
    rotate(nums, k)
    print(nums)  # [5, 6, 7, 1, 2, 3, 4]
