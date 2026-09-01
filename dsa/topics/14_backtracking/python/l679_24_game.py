# Problem: https://leetcode.com/problems/24-game/
# Idea: Backtracking: Try all possible operations on 2 numbers and then on the result with other 2 numbers.
# Time: O((4*4*4)^4)

OPS = ['+', '-', '*', '/']


def judgePoint24(cards):
    nums = [float(x) for x in cards]
    return dfs(nums)


def dfs(nums):
    n = len(nums)
    if n == 1:
        return abs(nums[0] - 24) < 1e-6

    for i in range(n):
        for j in range(n):
            if i == j:
                continue

            nxt = []
            for k in range(n):
                if k != i and k != j:
                    nxt.append(nums[k])

            for op in OPS:
                if op == '+':
                    nxt.append(nums[i] + nums[j])
                elif op == '-':
                    nxt.append(nums[i] - nums[j])
                elif op == '*':
                    nxt.append(nums[i] * nums[j])
                elif op == '/':
                    if nums[j] == 0:
                        continue
                    nxt.append(nums[i] / nums[j])

                if dfs(nxt):
                    return True

                nxt.pop()   # backtracking

    return False


# -------- Test --------
cards = [4, 1, 8, 7]
print(judgePoint24(cards))
# Expected: True
