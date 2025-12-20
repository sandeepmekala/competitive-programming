# Idea: Numbers can be paired and XoR can be applied.
# xor will be canceling all the even number of 1's.
# So we should make sure there are even 1's at each bit position to achieve this.
def make_array_elements_zero(nums):
    for i in range(32):
        bit_count = 0
        for num in nums:
            if ((num >> i) & 1) == 1:
                bit_count += 1

        if bit_count % 2 != 0:
            return False

    return True


# ------------------ Test (Same as Java main) ------------------

nums = [3, 5, 6]
print(make_array_elements_zero(nums))  # Expected: True
