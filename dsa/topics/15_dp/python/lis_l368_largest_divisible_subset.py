# Proble: https://leetcode.com/problems/largest-divisible-subset/
# Idea: Sort the nums. Apply the logic of lis but check divisibility instead of increasibility.
# Nums need to be sort to maintain the transitive divisibility property.
def largestDivisibleSubset(nums):
    n = len(nums)
    if n == 0:
        return []

    nums.sort()

    lds = [1] * n
    parent = [i for i in range(n)]

    maxLen = 0
    maxInd = 0

    for i in range(1, n):
        for j in range(i):
            if nums[i] % nums[j] == 0:
                if lds[j] + 1 > lds[i]:
                    lds[i] = lds[j] + 1
                    parent[i] = j

        if lds[i] > maxLen:
            maxLen = lds[i]
            maxInd = i

    return getLds(nums, parent, maxInd)


def getLds(nums, parent, largestInd):
    lds = []
    while largestInd != parent[largestInd]:
        lds.append(nums[largestInd])
        largestInd = parent[largestInd]

    lds.append(nums[largestInd])
    lds.reverse()
    return lds


# -------- Test (same as Java main) --------
nums = [1, 2, 4, 8]
print(largestDivisibleSubset(nums))
