# L229 - Majority Element II
#
# Problem: https://leetcode.com/problems/majority-element-ii/description/
# Idea: Moore's Voting algorithm
# There can be at most two elements appearing more than n/3 times
# Time: O(n)
# Space: O(1)


def majority_element(nums):
    cand1 = cand2 = None
    count1 = count2 = 0

    # Phase 1: Find potential candidates
    for num in nums:
        if num == cand1:
            count1 += 1
        elif num == cand2:
            count2 += 1
        elif count1 == 0:
            cand1, count1 = num, 1
        elif count2 == 0:
            cand2, count2 = num, 1
        else:
            count1 -= 1
            count2 -= 1

    # Phase 2: Verify candidates
    res = []
    for cand in (cand1, cand2):
        if cand is not None and nums.count(cand) > len(nums) // 3:
            res.append(cand)

    return res


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [2, 1, 1, 3, 1, 4, 5, 6]
    print(majority_element(nums))
