# L485 - Max Consecutive Ones
#
# Problem: https://leetcode.com/problems/max-consecutive-ones/
# Idea: If num = 1 then count++, else reset count = 0. Track global max.


def find_max_consecutive_ones(nums):
    max_count = 0
    current = 0

    for num in nums:
        if num == 1:
            current += 1
            max_count = max(max_count, current)
        else:
            current = 0

    return max_count


# -------------------- TEST --------------------
if __name__ == "__main__":
    nums = [1, 1, 0, 1, 1, 1]
    print(find_max_consecutive_ones(nums))  # 3
