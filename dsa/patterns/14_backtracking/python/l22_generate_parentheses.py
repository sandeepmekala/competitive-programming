# Problem: Generate Parentheses
# Idea:
# Use backtracking with counts of open and close brackets.
# We can add "(" if open < n
# We can add ")" if close < open
# When open == close == n, we have a valid combination.

def generate_parentheses(n):
    result = []
    backtrack("", 0, 0, n, result)
    return result


def backtrack(curr, open_cnt, close_cnt, n, result):
    # Base case: valid combination formed
    if open_cnt == n and close_cnt == n:
        result.append(curr)
        return

    # Try adding '('
    if open_cnt < n:
        backtrack(curr + "(", open_cnt + 1, close_cnt, n, result)

    # Try adding ')'
    if close_cnt < open_cnt:
        backtrack(curr + ")", open_cnt, close_cnt + 1, n, result)


# -------- Test --------
print(generate_parentheses(3))
