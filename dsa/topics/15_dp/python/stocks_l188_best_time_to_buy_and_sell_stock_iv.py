# DP / Stock
#
# Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
# At most k transactions
# Idea: Same as Stock III, but cap = k
# Sell reduces cap by 1
# Time: O(n*2*k)
# Space: O(n*2*k)

def maxProfitRecursive(prices, i=0, isBuy=1, cap=2):
    n = len(prices)
    if i == n or cap == 0:
        return 0

    if isBuy == 1:
        buy = -prices[i] + maxProfitRecursive(prices, i + 1, 0, cap)
        notBuy = maxProfitRecursive(prices, i + 1, 1, cap)
        return max(buy, notBuy)
    else:
        sell = prices[i] + maxProfitRecursive(prices, i + 1, 1, cap - 1)
        notSell = maxProfitRecursive(prices, i + 1, 0, cap)
        return max(sell, notSell)


def maxProfit(k, prices):
    n = len(prices)
    profits = [[[0] * (k + 1) for _ in range(2)] for _ in range(n + 1)]

    for i in range(n, -1, -1):
        for isBuy in range(2):
            for cap in range(k + 1):
                if i == n or cap == 0:
                    profits[i][isBuy][cap] = 0
                elif isBuy == 1:  # buy
                    buy = -prices[i] + profits[i + 1][0][cap]
                    notBuy = profits[i + 1][1][cap]
                    profits[i][isBuy][cap] = max(buy, notBuy)
                else:             # sell
                    sell = prices[i] + profits[i + 1][1][cap - 1]
                    notSell = profits[i + 1][0][cap]
                    profits[i][isBuy][cap] = max(sell, notSell)

    return profits[0][1][k]


# -------- Test --------
prices = [2, 4, 1]

print(maxProfitRecursive(prices, 0, 1, 2))  # Expected: 2
print(maxProfit(2, prices))                 # Expected: 2
