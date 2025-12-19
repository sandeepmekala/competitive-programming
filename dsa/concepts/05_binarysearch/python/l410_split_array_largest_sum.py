"""
LeetCode 410 - Split Array Largest Sum
(Book Allocation / Painter's Partition variant)

Idea:
Binary search on the answer.
- Minimum possible max sum = max(nums)
- Maximum possible max sum = sum(nums)

Check feasibility by counting how many subarrays
(students) are needed for a given max sum.

Time Complexity: O(n log(sum(nums)))
Space Complexity: O(1)
"""

def count_students(nums, max_pages):
    students = 1
    curr_sum = 0

    for num in nums:
        if curr_sum + num <= max_pages:
            curr_sum += num
        else:
            students += 1
            curr_sum = num

    return students


def split_array(nums, m):
    n = len(nums)

    # Impossible to split
    if m > n:
        return -1

    low = max(nums)      # at least the max element
    high = sum(nums)     # at most the total sum
    ans = high

    while low <= high:
        mid = (low + high) // 2

        required = count_students(nums, mid)

        if required <= m:
            ans = mid
            high = mid - 1   # try to minimize further
        else:
            low = mid + 1

    return ans


# Driver code
if __name__ == "__main__":
    nums = [25, 46, 28, 49, 24]
    m = 4
    print(split_array(nums, m))
