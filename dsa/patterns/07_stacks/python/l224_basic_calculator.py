"""
Problem: https://leetcode.com/problems/basic-calculator
"""

def calculate(s: str) -> int:
    postfix = infix_to_postfix(s)
    return eval_postfix(postfix)


# Idea:
# Push operators and parentheses to stack and pop them when we encounter closing parentheses.
# When we encounter a number, push it to result.
# When we encounter an operator, pop all operators from stack with higher or equal precedence.
# Wrap input in () to handle unary operators.
# Add 0 to result when we encounter unary - operator.
def infix_to_postfix(s: str):
    stack = []
    result = []

    s = "(" + s + ")"          # wrap to handle unary cases like "-2+5"
    check_unary = False
    i = 0

    while i < len(s):
        ch = s[i]

        if ch == ' ':
            i += 1
            continue

        if check_unary:
            if ch == '-':
                result.append("0")
            check_unary = False

        if ch.isdigit():
            num = ch
            while i + 1 < len(s) and s[i + 1].isdigit():
                i += 1
                num += s[i]
            result.append(num)

        elif ch == '(':
            stack.append(ch)
            check_unary = True

        elif ch == ')':
            while stack and stack[-1] != '(':
                result.append(stack.pop())
            stack.pop()  # remove '('

        else:  # operator
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
    return -1


def eval_postfix(tokens):
    stack = []

    for token in tokens:
        if token not in {"+", "-"}:
            stack.append(int(token))
        else:
            op2 = stack.pop()
            op1 = stack.pop()
            if token == "+":
                stack.append(op1 + op2)
            else:
                stack.append(op1 - op2)

    return stack.pop()


# Example usage
if __name__ == "__main__":
    print(calculate("-2+5"))               # 3
    print(calculate("2-1 + 2"))            # 3
    print(calculate("(1+(4+5+2)-3)+(6+8)"))  # 23
