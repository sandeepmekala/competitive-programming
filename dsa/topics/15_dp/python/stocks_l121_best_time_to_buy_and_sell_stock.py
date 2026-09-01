# Greedy
#
# Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
# Only one transaction
# Idea: Track the min price so far to subtract from current price.
#
#  i/j   7   1   5   3   6   4
#        0   0   4   4   5   5
#
# Time: O(n)
# Space: O(1)

def maxProfit(prices):
    minimum = prices[0]
    profit = 0

    for i in range(1, len(prices)):
        cost = prices[i] - minimum
        profit = max(profit, cost)
        minimum = min(minimum, prices[i])

    return profit


# -------- Test --------
print(maxProfit([7, 1, 5, 3, 6, 4]))  # Expected: 5
