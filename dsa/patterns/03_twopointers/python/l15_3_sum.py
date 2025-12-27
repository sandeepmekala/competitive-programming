# L15 - Three Sum
#
# Problem: https://leetcode.com/problems/3sum/
#
# Idea:
# - Sort the array
# - Fix one element and use two pointers for the remaining two
# - Skip duplicates to avoid repeated triplets
#
# Time: O(n^2)
# Space: O(1) excluding the result array


def three_sum(nums):
    result = []
    n = len(nums)

    if n < 3:
        return result

    nums.sort()

    for i in range(n - 2):
        # Skip duplicate fixed elements
        if i > 0 and nums[i] == nums[i - 1]:
            continue

        left, right = i + 1, n - 1

        while left < right:
            total = nums[i] + nums[left] + nums[right]

            if total < 0:
                left += 1
            elif total > 0:
                right -= 1
            else:
                result.append([nums[i], nums[left], nums[right]])
                left += 1
                right -= 1

                # Skip duplicates
                while left < right and nums[left] == nums[left - 1]:
                    left += 1
                while left < right and nums[right] == nums[right + 1]:
                    right -= 1

    return result


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [-2, 0, 0, 2, 2]
    print(three_sum(nums))  # Output: [[-2, 0, 2]]
