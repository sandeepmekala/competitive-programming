# Problem: https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/
def first_recurring_character(input_str):
    seen = set()

    for c in input_str:
        if c in seen:
            return c
        seen.add(c)

    return None   # equivalent to returning 0 char in Java


# ------------------ Test (Same as Java main) ------------------

print(first_recurring_character("DBBCAA"))  # Expected: 'B'
