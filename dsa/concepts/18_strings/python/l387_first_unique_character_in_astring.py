# Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
# Idea: Track the freq in linkedHashMap and return first char with freq 1.
def first_uniq_char(s):
    freq = {}

    for ch in s:
        freq[ch] = freq.get(ch, 0) + 1

    for ch, count in freq.items():   # dict preserves insertion order (LinkedHashMap behavior)
        if count == 1:
            return s.index(ch)

    return -1


# ------------------ Test (Same as Java main) ------------------

print(first_uniq_char("leetcode"))  # Expected: 0
