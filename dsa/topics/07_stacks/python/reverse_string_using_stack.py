"""
Idea:
Reverse a string using a stack.
Push all characters to the stack, then pop them to build the reversed string.
"""

def reverse_string_using_stack(s: str) -> str:
    stack = []
    result = []

    for ch in s:
        stack.append(ch)

    while stack:
        result.append(stack.pop())

    return "".join(result)


# Example usage
if __name__ == "__main__":
    s = "google"
    print(reverse_string_using_stack(s))  # elgoog
