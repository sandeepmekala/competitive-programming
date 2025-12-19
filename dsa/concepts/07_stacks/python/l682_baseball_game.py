"""
Problem: https://leetcode.com/problems/baseball-game/
Idea:
Since all operations depend on the most recent scores,
use a stack to track and update recent points.
"""

def cal_points(ops):
    stack = []

    for op in ops:
        if op == "C":
            stack.pop()
        elif op == "D":
            stack.append(stack[-1] * 2)
        elif op == "+":
            stack.append(stack[-1] + stack[-2])
        else:
            stack.append(int(op))

    return sum(stack)


# Example usage
if __name__ == "__main__":
    ops = ["5", "2", "C", "D", "+"]
    print(cal_points(ops))  # 30
