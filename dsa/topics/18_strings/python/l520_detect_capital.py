# Problem: https://leetcode.com/problems/detect-capital/
# Idea: Use startCapital and continuesCapital vars to track the status
# TODO
def detect_capital_use(word):
    starts_cap = False
    continues_cap = False

    for i in range(len(word)):
        ch = word[i]

        if i == 0:
            if 'A' <= ch <= 'Z':
                starts_cap = True
                continue

        if i == 1:
            if 'A' <= ch <= 'Z':
                continues_cap = True

        if starts_cap and continues_cap and 'a' <= ch <= 'z':
            return False
        if starts_cap and not continues_cap and 'A' <= ch <= 'Z':
            return False
        if not starts_cap and 'A' <= ch <= 'Z':
            return False

    return True


# ------------------ Test (Same as Java main) ------------------

word = "USA"
print(detect_capital_use(word))  # Expected: True
