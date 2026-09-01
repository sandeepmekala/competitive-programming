# DP / Stock
#
# Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
# Unlimited transactions but one at a time, each transaction costs a constant fee
# Idea: Track buy/sell state; subtract fee on sell
# Time: O(n*2)
# Space: O(n*2)

def maxProfit(prices, fee):
    n = len(prices)
    profits = [[0] * 2 for _ in range(n + 1)]

    for i in range(n, -1, -1):
        for isBuy in range(2):
            if i == n:
                profits[i][isBuy] = 0
            elif isBuy == 1:  # allowed to buy
                buy = -prices[i] + profits[i + 1][0]
                notBuy = profits[i + 1][1]
                profits[i][isBuy] = max(buy, notBuy)
            else:  # allowed to sell
                sell = prices[i] - fee + profits[i + 1][1]
                notSell = profits[i + 1][0]
                profits[i][isBuy] = max(sell, notSell)

    return profits[0][1]


def maxProfitRecursive(prices, fee, ind=0, isBuy=1):
    n = len(prices)
    if ind == n:
        return 0

    if isBuy == 1:
        buy = -prices[ind] + maxProfitRecursive(prices, fee, ind + 1, 0)
        notBuy = maxProfitRecursive(prices, fee, ind + 1, 1)
        return max(buy, notBuy)
    else:
        sell = prices[ind] - fee + maxProfitRecursive(prices, fee, ind + 1, 1)
        notSell = maxProfitRecursive(prices, fee, ind + 1, 0)
        return max(sell, notSell)


# -------- Test --------
prices = [1, 3, 2, 8, 4, 9]
fee = 2

print(maxProfit(prices, fee))                     # Expected: 8
print(maxProfitRecursive(prices, fee, 0, 1))     # Expected: 8
