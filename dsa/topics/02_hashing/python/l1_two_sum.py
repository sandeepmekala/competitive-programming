# L1 - Two Sum
#
# Problem: https://leetcode.com/problems/two-sum/
#
# Idea:
# - Use a hashmap to store number → index
# - For each number, check if (target - number) exists
#
# Time: O(n)
# Space: O(n)


def two_sum(nums, target):
    index_map = {}

    for i, num in enumerate(nums):
        complement = target - num

        if complement in index_map:
            return [index_map[complement], i]

        index_map[num] = i

    return []


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    print(two_sum(nums, target))  # Output: [0, 1]
