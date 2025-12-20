# Problem: Minimum number of coins
# Idea: Greedy
# Always pick the largest coin possible that is <= remaining value.
# Works because Indian coin system is canonical.
# Time: O(n)
# Space: O(n)

def minimum_coins(coins, V):
    result = []

    # traverse coins from largest to smallest
    for coin in reversed(coins):
        while V >= coin:
            V -= coin
            result.append(coin)

    return result


# -------- Test --------
coins = [1, 2, 5, 10, 20, 50, 100, 500, 1000]
V = 49

ans = minimum_coins(coins, V)

print("The minimum number of coins is", len(ans))
print("The coins are:")
print(ans)
