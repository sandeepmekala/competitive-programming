# Problem: https://leetcode.com/problems/excel-sheet-column-number/
# Companies: Google
# Idea: Move left to right. Mulitiply the result by 26 to shift it right,
# then add curr char num.
def title_to_number(column_title):
    result = 0
    for ch in column_title:
        result *= 26
        result += ord(ch) - ord('A') + 1
    return result


# ------------------ Test (Same as Java main) ------------------

print(title_to_number("AA"))  # Expected: 27
