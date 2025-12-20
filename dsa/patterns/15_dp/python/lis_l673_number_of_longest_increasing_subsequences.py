# Problem: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
# Idea: With lis array, we need to have a cnt array also.
# When you find a j which update i lis, we need to copy j's count as number of ways as sequence can be formed with i is number of ways sequnce is form till j.
# Once you find another j which form same cnt of i, we need to add cnt of it to the cnt of i as the similar length sequences can be formed with that j also.
def findNumberOfLIS(nums):
    n = len(nums)
    if n == 1:
        return 1

    lis = [1] * n          # lis for each element is itself
    cnt = [1] * n          # count of lis ending at each index

    maxLen = 0
    for i in range(1, n):
        for j in range(i):
            if nums[j] < nums[i]:
                if 1 + lis[j] > lis[i]:
                    lis[i] = 1 + lis[j]
                    cnt[i] = cnt[j]
                elif 1 + lis[j] == lis[i]:
                    cnt[i] += cnt[j]

        if lis[i] > maxLen:     # just track max to return
            maxLen = lis[i]

    count = 0
    for i in range(n):
        if lis[i] == maxLen:
            count += cnt[i]

    return count


# -------- Test (same as Java main) --------
nums = [1, 3, 5, 4, 7]
print(findNumberOfLIS(nums))
