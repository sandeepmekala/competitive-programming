# DP / Stock
#
# Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
# At most 2 transactions
# Idea: Same as Stock II, but an additional dimension 'cap' is added.
# Once a sell is counted, cap reduces by 1.
# Time: O(n*2*2)
# Space: O(n*2*3)

def maxProfit(prices):
    n = len(prices)
    profits = [[[0] * 3 for _ in range(2)] for _ in range(n + 1)]

    for i in range(n, -1, -1):
        for isBuy in range(2):
            for cap in range(3):
                if i == n or cap == 0:
                    profits[i][isBuy][cap] = 0
                elif isBuy == 1:  # buy
                    buy = -prices[i] + profits[i + 1][0][cap]
                    notBuy = profits[i + 1][1][cap]
                    profits[i][isBuy][cap] = max(buy, notBuy)
                else:            # sell
                    sell = prices[i] + profits[i + 1][1][cap - 1]
                    notSell = profits[i + 1][0][cap]
                    profits[i][isBuy][cap] = max(sell, notSell)

    return profits[0][1][2]


def maxProfitRecursive(prices, ind=0, isBuy=1, cap=2):
    n = len(prices)
    if ind == n or cap == 0:
        return 0

    if isBuy == 1:
        buy = -prices[ind] + maxProfitRecursive(prices, ind + 1, 0, cap)
        notBuy = maxProfitRecursive(prices, ind + 1, 1, cap)
        return max(buy, notBuy)
    else:
        sell = prices[ind] + maxProfitRecursive(prices, ind + 1, 1, cap - 1)
        notSell = maxProfitRecursive(prices, ind + 1, 0, cap)
        return max(sell, notSell)


# -------- Test --------
prices = [3, 3, 5, 0, 0, 3, 1, 4]

print(maxProfit(prices))                     # Expected: 6
print(maxProfitRecursive(prices, 0, 1, 2))  # Expected: 6
