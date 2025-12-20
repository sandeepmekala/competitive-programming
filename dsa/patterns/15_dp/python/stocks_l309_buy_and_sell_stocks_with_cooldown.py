# DP / Stock
#
# Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
# Unlimited transactions but one at a time, with cooldown after sell
# Idea: Track buy/sell state; if selling, skip next day (cooldown)
# Time: O(n*2)
# Space: O(n*2)

def maxProfit(prices):
    n = len(prices)
    profits = [[0] * 2 for _ in range(n + 2)]  # n+2 to handle cooldown indexing

    for i in range(n, -1, -1):
        for isBuy in range(2):
            if i == n:
                profits[i][isBuy] = 0
            elif isBuy == 1:  # allowed to buy
                buy = -prices[i] + profits[i + 1][0]
                notBuy = profits[i + 1][1]
                profits[i][isBuy] = max(buy, notBuy)
            else:  # allowed to sell
                sell = prices[i] + profits[i + 2][1]  # cooldown next day
                notSell = profits[i + 1][0]
                profits[i][isBuy] = max(sell, notSell)

    return profits[0][1]


def maxProfitRecursive(prices, ind=0, isBuy=1):
    n = len(prices)
    if ind >= n:
        return 0

    if isBuy == 1:
        buy = -prices[ind] + maxProfitRecursive(prices, ind + 1, 0)
        notBuy = maxProfitRecursive(prices, ind + 1, 1)
        return max(buy, notBuy)
    else:
        sell = prices[ind] + maxProfitRecursive(prices, ind + 2, 1)  # cooldown
        notSell = maxProfitRecursive(prices, ind + 1, 0)
        return max(sell, notSell)


# -------- Test --------
prices = [1, 2, 3, 0, 2]

print(maxProfit(prices))                 # Expected: 3
print(maxProfitRecursive(prices, 0, 1))  # Expected: 3
