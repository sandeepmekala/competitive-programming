"""
Problem: https://leetcode.com/problems/evaluate-reverse-polish-notation/
Idea:
Evaluate the expression from left to right.
Push numbers onto a stack.
When an operator is found, pop two operands, apply the operator,
and push the result back to the stack.

EvaluatePrefix is similar, except traversal is from right to left.
For EvaluatePrefix, operand order changes:
first popped value is op1, second popped value is op2.
"""

def eval_rpn(tokens):
    operators = {"+", "-", "*", "/"}
    stack = []

    for token in tokens:
        if token not in operators:
            stack.append(int(token))
        else:
            op2 = stack.pop()
            op1 = stack.pop()

            if token == "+":
                stack.append(op1 + op2)
            elif token == "-":
                stack.append(op1 - op2)
            elif token == "*":
                stack.append(op1 * op2)
            else:
                # Truncate towards zero (matches LeetCode behavior)
                stack.append(int(op1 / op2))

    return stack.pop()


# Example usage
if __name__ == "__main__":
    print(eval_rpn(["2", "1", "+", "3", "*"]))  # 9
