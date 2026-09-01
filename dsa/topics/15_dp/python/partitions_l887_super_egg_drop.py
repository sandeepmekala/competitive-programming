# DP / Partition DP
#
# Problem: https://leetcode.com/problems/super-egg-drop/

def superEggDrop(eggs, floors):
    dp = [[0] * (floors + 1) for _ in range(eggs + 1)]

    # Base case: only 1 egg
    for i in range(floors + 1):
        dp[1][i] = i

    for e in range(2, eggs + 1):
        for f in range(1, floors + 1):
            minimum = float('inf')
            for k in range(1, f + 1):
                moves = 1 + max(dp[e - 1][k - 1], dp[e][f - k])
                minimum = min(minimum, moves)
            dp[e][f] = minimum

    return dp[eggs][floors]


def calculateRecursive(eggs, floors):
    if eggs == 1:
        return floors
    if floors == 0:
        return 0

    minimum = float('inf')
    for k in range(1, floors + 1):
        moves = 1 + max(
            calculateRecursive(eggs - 1, k - 1),
            calculateRecursive(eggs, floors - k)
        )
        minimum = min(minimum, moves)

    return minimum


# -------- Test --------
print(superEggDrop(2, 6))        # Expected: 3
# print(calculateRecursive(2, 6))  # Also returns 3 (but very slow)
