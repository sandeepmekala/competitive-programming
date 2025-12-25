# L169 - Majority Element
#
# Problem: https://leetcode.com/problems/majority-element/
# Idea: Moore's Voting algorithm
# The majority element is the element that appears more than ⌊n/2⌋ times.
# Time: O(n)
# Space: O(1)


def majority_element(nums):
    candidate = None
    count = 0

    # Phase 1: Find potential candidate
    for num in nums:
        if count == 0:
            candidate = num
            count = 1
        elif num == candidate:
            count += 1
        else:
            count -= 1

    return candidate


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [3, 2, 3]
    print(majority_element(nums))
