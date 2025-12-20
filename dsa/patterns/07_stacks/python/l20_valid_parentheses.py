"""
Problem: https://leetcode.com/problems/valid-parentheses/
Idea:
Push opening brackets to a stack.
When a closing bracket is found, check whether it matches
the top of the stack.
"""

def is_valid(s: str) -> bool:
    bracket_map = {
        '(': ')',
        '{': '}',
        '[': ']'
    }

    stack = []

    for ch in s:
        # opening bracket
        if ch in bracket_map:
            stack.append(ch)
        else:  # closing bracket
            if not stack or bracket_map[stack[-1]] != ch:
                return False
            stack.pop()

    return not stack


# Example usage
if __name__ == "__main__":
    print(is_valid("[()]"))  # True
