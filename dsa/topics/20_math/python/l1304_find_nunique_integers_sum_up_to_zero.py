# Problem: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
# Idea: Just 1,2,.. -2,-1 from both sides of array
# Companies: Microsoft
def sum_zero(n):
    result = [0] * n

    for i in range(n // 2):
        result[i] = i + 1
        result[n - 1 - i] = -(i + 1)

    return result


# ------------------ Test (Same as Java main) ------------------

print(sum_zero(5))  # Example output: [1, 2, 0, -2, -1]
