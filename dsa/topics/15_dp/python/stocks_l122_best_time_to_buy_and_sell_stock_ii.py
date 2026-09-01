# DP / Stock
#
# Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
# Unlimited transactions but one at a time
# Idea:
# We track whether we are allowed to buy (isBuy=1) or sell (isBuy=0)
# Buying contributes -price, selling contributes +price
# DP state: dp[i][isBuy] = max profit starting at index i with buy/sell state

def maxProfit(prices):
    n = len(prices)
    dp = [[0] * 2 for _ in range(n + 1)]

    for i in range(n - 1, -1, -1):
        for isBuy in range(2):
            if isBuy == 1:  # allowed to buy
                buy = -prices[i] + dp[i + 1][0]
                notBuy = dp[i + 1][1]
                dp[i][isBuy] = max(buy, notBuy)
            else:           # allowed to sell
                sell = prices[i] + dp[i + 1][1]
                notSell = dp[i + 1][0]
                dp[i][isBuy] = max(sell, notSell)

    return dp[0][1]


def maxProfitRecursive(prices, ind=0, isBuy=1):
    n = len(prices)
    if ind == n:
        return 0

    if isBuy == 1:
        buy = -prices[ind] + maxProfitRecursive(prices, ind + 1, 0)
        notBuy = maxProfitRecursive(prices, ind + 1, 1)
        return max(buy, notBuy)
    else:
        sell = prices[ind] + maxProfitRecursive(prices, ind + 1, 1)
        notSell = maxProfitRecursive(prices, ind + 1, 0)
        return max(sell, notSell)


# -------- Test --------
prices = [7, 1, 5, 3, 6, 4]

print(maxProfit(prices))                  # Expected: 7
print(maxProfitRecursive(prices, 0, 1))  # Expected: 7
