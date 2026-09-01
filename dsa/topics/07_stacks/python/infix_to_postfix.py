"""
Problems:
https://leetcode.com/problems/basic-calculator/
https://leetcode.com/problems/basic-calculator-ii/
https://leetcode.com/problems/basic-calculator-iii/

Idea:
Convert infix expression to postfix (Reverse Polish Notation)
and then evaluate postfix expression using a stack.
"""

def infix_to_postfix(expression):
    stack = []
    result = []
    i = 0

    while i < len(expression):
        ch = expression[i]

        # Operand (number or variable)
        if is_operand(ch):
            token = ch
            while i + 1 < len(expression) and is_operand(expression[i + 1]):
                i += 1
                token += expression[i]
            result.append(token)

        # Operator
        elif is_operator(ch):
            while stack and has_higher_precedence(stack[-1], ch):
                result.append(stack.pop())
            stack.append(ch)

        i += 1

    while stack:
        result.append(stack.pop())

    return result


def infix_to_postfix_with_parentheses(expression):
    stack = []
    result = []
    i = 0

    while i < len(expression):
        ch = expression[i]

        # Operand
        if is_operand(ch):
            token = ch
            while i + 1 < len(expression) and is_operand(expression[i + 1]):
                i += 1
                token += expression[i]
            result.append(token)

        # Opening parenthesis
        elif ch == '(':
            stack.append(ch)

        # Closing parenthesis
        elif ch == ')':
            while stack and stack[-1] != '(':
                result.append(stack.pop())
            stack.pop()  # remove '('

        # Operator
        elif is_operator(ch):
            while stack and has_higher_precedence(stack[-1], ch):
                result.append(stack.pop())
            stack.append(ch)

        i += 1

    while stack:
        result.append(stack.pop())

    return result


def is_operand(ch):
    return ch.isalnum()


def is_operator(ch):
    return ch in "+-*/$"


def has_higher_precedence(op1, op2):
    w1 = operator_weight(op1)
    w2 = operator_weight(op2)

    # If same precedence, left associative gets priority
    if w1 == w2:
        return not is_right_associative(op1)

    return w1 > w2


def is_right_associative(op):
    return op == '$'


def operator_weight(op):
    if op in '+-':
        return 1
    if op in '*/':
        return 2
    if op == '$':
        return 3
    return -1


# Example usage
if __name__ == "__main__":
    print(infix_to_postfix("A+B*C-D*E"))
    print(infix_to_postfix_with_parentheses("((A+B)*C-D)*E"))
