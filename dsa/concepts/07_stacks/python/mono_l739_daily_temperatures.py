"""
Problem: https://leetcode.com/problems/daily-temperatures/
Idea:
Same as Next Greater Element.
Traverse from right to left and maintain a monotonically decreasing stack.
For each day, find how many days you need to wait to get a warmer temperature.
"""

def daily_temperatures(temps):
    n = len(temps)
    answer = [0] * n
    stack = []  # will store indices

    for i in range(n - 1, -1, -1):
        while stack and temps[stack[-1]] <= temps[i]:
            stack.pop()

        answer[i] = stack[-1] - i if stack else 0
        stack.append(i)

    return answer


# Example usage
if __name__ == "__main__":
    temps = [73, 74, 75, 71, 69, 72, 76, 73]
    print(daily_temperatures(temps))  # [1, 1, 4, 2, 1, 1, 0, 0]
