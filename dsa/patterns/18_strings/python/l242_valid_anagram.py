# Problem: https://leetcode.com/problems/valid-anagram/
# Idea: Count the char freq and compare
def is_anagram(s, t):
    if len(s) != len(t):
        return False

    freq = {}
    for ch in s:
        freq[ch] = freq.get(ch, 0) + 1

    for ch in t:
        if ch not in freq:
            return False
        freq[ch] -= 1

    for ch in freq:
        if freq[ch] != 0:
            return False

    return True


# ------------------ Test (Same as Java main) ------------------

print(is_anagram("anagram", "nagaram"))  # Expected: True
