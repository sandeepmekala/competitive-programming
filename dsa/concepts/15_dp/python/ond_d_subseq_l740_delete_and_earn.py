# DP / House Robber Variant
#
# Problem: https://leetcode.com/problems/delete-and-earn/
# Companies: Amazon
# Idea: It is similar to House robber. All the adjacend nums can be treated as adjacent houses.
# If a num is picked, all it repeats should be summed and that is the profit. Hence we track all the sums in a map.
# To get all nums in adjacent order, we get the max of nums, loop till max.
# While looping till max, apply House robber algo on adjacent nums.
#
# Time: O(max)
# Space: O(max)

def delete_and_earn(nums):
    max_num = 0
    freq_sum = {}

    # Build value-to-total-earnings map
    for num in nums:
        max_num = max(max_num, num)
        freq_sum[num] = freq_sum.get(num, 0) + num

    # House robber DP
    earn = [0] * (max_num + 1)
    if max_num >= 1:
        earn[1] = freq_sum.get(1, 0)   # only one house is there

    for i in range(2, max_num + 1):
        not_take = earn[i - 1]
        take = freq_sum.get(i, 0) + earn[i - 2]
        earn[i] = max(take, not_take)

    return earn[max_num]


# -------- Test --------
nums = [2, 2, 3, 3, 3, 4]
print(delete_and_earn(nums))  # Expected: 9
