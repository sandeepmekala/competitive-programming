# Leaders In An Array Problem
#
# Problem: https://www.geeksforgeeks.org/leaders-in-an-array/
# Idea: Traverse from right to left. If num is greater than max till now, then it is a leader.


def print_leaders(nums):
    max_val = float('-inf')
    n = len(nums)
    result = []

    for i in range(n - 1, -1, -1):
        if nums[i] > max_val:
            max_val = nums[i]
            result.append(nums[i])

    result.sort()
    return result


if __name__ == "__main__":
    arr = [16, 17, 4, 3, 5, 2]
    print(print_leaders(arr))
