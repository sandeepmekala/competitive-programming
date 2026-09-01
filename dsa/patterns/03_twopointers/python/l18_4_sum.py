# L18 - Four Sum
#
# Problem: https://leetcode.com/problems/4sum/
#
# Idea:
# - Sort the array
# - Fix two numbers and use two pointers for the remaining two
# - Skip duplicates to avoid repeated quadruplets
#
# Time: O(n^3)
# Space: O(1) excluding the result array


def four_sum(nums, target):
    result = []
    n = len(nums)

    if n < 4:
        return result

    nums.sort()

    for i in range(n - 3):
        if i > 0 and nums[i] == nums[i - 1]:
            continue

        # Pruning: smallest possible sum is too large
        if nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target:
            break

        # Pruning: largest possible sum is too small
        if nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target:
            continue

        for j in range(i + 1, n - 2):
            if j > i + 1 and nums[j] == nums[j - 1]:
                continue

            left, right = j + 1, n - 1
            remaining = target - nums[i] - nums[j]

            while left < right:
                total = nums[left] + nums[right]

                if total == remaining:
                    result.append([nums[i], nums[j], nums[left], nums[right]])
                    left += 1
                    right -= 1

                    # Skip duplicates
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1

                elif total < remaining:
                    left += 1
                else:
                    right -= 1

    return result


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 0, -1, 0, -2, 2]
    target = 0
    print(four_sum(nums, target))
    # Output:
    # [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
