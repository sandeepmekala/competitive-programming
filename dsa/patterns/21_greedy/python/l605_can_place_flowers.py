# Problem: https://leetcode.com/problems/can-place-flowers/
# Idea: Just skip the cell if i, i-1, i+1 positions contains 1

def canPlaceFlowers(flowerbed, n):
    length = len(flowerbed)

    for i in range(length):
        if flowerbed[i] == 1:
            continue
        if i > 0 and flowerbed[i - 1] == 1:
            continue
        if i < length - 1 and flowerbed[i + 1] == 1:
            continue

        flowerbed[i] = 1
        n -= 1

    return n <= 0


# -------- Test --------
print(canPlaceFlowers([1, 0, 0, 0, 0, 1], 2))  # Expected: False
