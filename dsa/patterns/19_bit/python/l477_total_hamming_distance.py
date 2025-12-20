# Problem: https://leetcode.com/problems/total-hamming-distance/
# Idea: We can get the hamming distance by doing xor. Getting all pairs will lead to O(n^2).
# If we look at all the bits at a particular position, we can figure out the each 1 need to be paired with each 0.
# I.e no. of 1's * no. of 0's.
def total_hamming_distance(nums):
    count = 0
    n = len(nums)

    for i in range(32):
        no_of_ones = 0
        for num in nums:
            if ((num >> i) & 1) == 1:
                no_of_ones += 1

        num_of_zeros = n - no_of_ones
        count += no_of_ones * num_of_zeros

    return count


# ------------------ Test (Same as Java main) ------------------

numbers = [4, 14, 2]
print(total_hamming_distance(numbers))  # Expected: 6
