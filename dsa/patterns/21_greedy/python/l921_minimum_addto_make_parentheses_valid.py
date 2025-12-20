# Problem: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
# Idea: Count the number of open parentheses. Cancel out the open parentheses with close parentheses.
# If open parentheses is 0 to cancel out, then increment the count of close parentheses.
# Answer: remaining open parentheses + unmatched close parentheses
# Time: O(n), Space: O(1)

def minAddToMakeValid(s):
    open_cnt = 0
    close_cnt = 0

    for ch in s:
        if ch == '(':
            open_cnt += 1
        else:
            if open_cnt > 0:
                open_cnt -= 1
            else:
                close_cnt += 1

    return open_cnt + close_cnt


# -------- Tests --------
print(minAddToMakeValid("())"))     # 1
print(minAddToMakeValid("((("))     # 3
print(minAddToMakeValid("()"))      # 0
print(minAddToMakeValid("()))(("))  # 4
