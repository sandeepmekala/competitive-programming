# L217 - Contains Duplicate
#
# Problem: https://leetcode.com/problems/contains-duplicate/
#
# Idea:
# - Use a set to track unique elements
#
# Time: O(n)
# Space: O(n)
def contains_duplicate(nums):
    seen = set()

    for num in nums:
        if num in seen:
            return True
        seen.add(num)

    return False


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 2, 3, 1]
    print(contains_duplicate(nums))  # Output: True
