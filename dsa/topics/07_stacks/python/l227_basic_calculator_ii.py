"""
Problem: https://leetcode.com/problems/basic-calculator-ii/
Idea:
Convert infix expression to postfix and evaluate postfix.
Unary operators are not a concern here because the problem guarantees
valid input and no parentheses.
"""

def calculate(s: str) -> int:
    postfix = infix_to_postfix(s)
    return eval_postfix(postfix)


def infix_to_postfix(s: str):
    stack = []
    result = []
    i = 0

    while i < len(s):
        ch = s[i]

        if ch == ' ':
            i += 1
            continue

        # number
        if ch.isdigit():
            num = ch
            while i + 1 < len(s) and s[i + 1].isdigit():
                i += 1
                num += s[i]
            result.append(num)

        # operator
        else:
            while stack and operator_weight(stack[-1]) >= operator_weight(ch):
                result.append(stack.pop())
            stack.append(ch)

        i += 1

    while stack:
        result.append(stack.pop())

    return result


def operator_weight(op: str) -> int:
    if op in "+-":
        return 1
    if op in "*/":
        return 2
    return -1


def eval_postfix(tokens):
    stack = []

    for token in tokens:
        if token not in {"+", "-", "*", "/"}:
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
                # truncate towards zero
                stack.append(int(op1 / op2))

    return stack.pop()


# Example usage
if __name__ == "__main__":
    s = "3+20*2"
    print(calculate(s))  # 43
