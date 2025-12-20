# Problem: https://leetcode.com/problems/valid-parenthesis-string/
# Idea: The idea is to track the min and max left parenthesis that can be there in string.
# Decrease min if you are assuming * as )
# Increase max if you are assuming * as (
# At the end of the string we should have 0 min means, we mapped every ( with )
# At any point we should have count("(") >= count(")"). If min goes -ve, means we assumed
# somewhere the * as ). In the best case we can have ) which makes min = 0. So reset min to 0.
# At any point we should always have min <= max, else return false.
# Time: O(n), Space: O(1)

def checkValidString(s):
    min_open = 0
    max_open = 0

    for ch in s:
        if ch == '(':
            min_open += 1
            max_open += 1
        elif ch == ')':
            min_open -= 1
            max_open -= 1
        else:  # '*'
            min_open -= 1
            max_open += 1

        if min_open < 0:   # cannot have negative '('
            min_open = 0
        if max_open < min_open:
            return False

    return min_open == 0


# Basic version without '*'
def checkValidBasicString(s):
    open_count = 0
    for ch in s:
        if ch == '(':
            open_count += 1
        else:
            open_count -= 1

        if open_count < 0:
            return False

    return open_count == 0


# -------- Tests --------
print(checkValidBasicString("()()"))   # True
print(checkValidBasicString("(()"))    # False

print(checkValidString("(*))"))        # True
print(checkValidString(")"))           # False
