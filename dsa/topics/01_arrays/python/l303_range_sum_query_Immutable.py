# Range Sum Query - Immutable
# Problem: https://leetcode.com/problems/range-sum-query-immutable/
# Idea:
# - Precompute prefix sums
# - sumRange(left, right) =
#   prefix[right] - prefix[left] + nums[left]
#
# Time:
#   Preprocessing: O(n)
#   Query: O(1)
#
# Space: O(n)


class NumArray:
    def __init__(self, nums):
        self.nums = nums
        self.prefix = []
        sum = 0

        for num in nums:
            sum += num
            self.prefix.append(sum)

    def sumRange(self, left: int, right: int) -> int:
        return self.prefix[right] - self.prefix[left] + self.nums[left]

    def sumRange(self, left, right):
        return self.prefix[right] - self.prefix[left] + self.nums[left]


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 2, 3, 4, 5]
    obj = NumArray(nums)
    print(obj.sumRange(1, 3))  # Output: 9
