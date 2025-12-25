def second_largest(nums):
    first = float("-inf")
    sec = float("-inf")

    for num in nums:
        if num > first:
            sec = first
            first = num
        elif first > num > sec:
            sec = num
    return sec


print(second_largest([12, 35, 1, 10, 34, 1]))  # Output: 34
