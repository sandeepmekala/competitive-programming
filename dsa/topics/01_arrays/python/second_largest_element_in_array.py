# Second Largest Element In Array
#
# Problem: Find the second largest element in an array


def find_second_largest(nums):
    first = float("-inf")
    second = float("-inf")

    for num in nums:
        if num > first:
            second = first
            first = num
        elif first > num > second:
            second = num

    return second


# -------------------- TEST --------------------
if __name__ == "__main__":
    arr = [12, 35, 1, 10, 34, 1]
    print(find_second_largest(arr))  # Output: 34
