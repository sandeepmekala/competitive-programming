# Problem: https://leetcode.com/problems/permutation-sequence/
# Idea: Permutations are in the blocks. Use / and % to find the right block every time.
# Each block of permutations starts with a number which need to be appended to result.
def get_permutation(n, k):
    k = k - 1    # we will be using 0 based indexing

    fact = 1     # find (n-1)!
    nums = []
    for i in range(1, n):
        fact *= i
        nums.append(i)
    nums.append(n)

    result = []
    while True:
        block = k // fact
        result.append(str(nums[block]))
        nums.pop(block)

        if not nums:
            break

        k = k % fact
        fact = fact // len(nums)

    return "".join(result)


# ------------------ Test (Same as Java main) ------------------

n = 3
k = 3
print(get_permutation(n, k))  # Expected: "213"
