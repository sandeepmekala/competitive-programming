"""
LeetCode 34 - Find First and Last Position of Element in Sorted Array

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def search_range(nums, target):
    def lower_bound():
        low, high = 0, len(nums) - 1
        res = -1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] >= target:
                if nums[mid] == target:
                    res = mid
                high = mid - 1
            else:
                low = mid + 1
        return res

    def upper_bound():
        low, high = 0, len(nums) - 1
        res = -1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] <= target:
                if nums[mid] == target:
                    res = mid
                low = mid + 1
            else:
                high = mid - 1
        return res

    return [lower_bound(), upper_bound()]


# Driver
if __name__ == "__main__":
    print(search_range([5,7,7,8,8,10], 8))  # [3, 4]
