# Problem: https://leetcode.com/problems/excel-sheet-column-title/
# Idea: As the num is 1 indexed, subtract 1 from it and take reminder from num.
def convert_to_title(column_number):
    sb = []

    while column_number > 0:
        column_number -= 1
        rem = column_number % 26
        sb.append(chr(ord('A') + rem))
        column_number = column_number // 26

    return "".join(reversed(sb))


# ------------------ Test (Same as Java main) ------------------

print(convert_to_title(27))  # Expected: "AA"
