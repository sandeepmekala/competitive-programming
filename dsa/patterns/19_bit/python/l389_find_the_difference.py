# Problem: https://leetcode.com/problems/find-the-difference/
# Companies: Google
# Idea: s and t has chars repeating. Hence do xor to eliminate all the repeating chars.
# At the end, the odd char remains.
def find_the_difference(s, t):
    chr_val = 0
    for ch in s:
        chr_val ^= ord(ch)
    for ch in t:
        chr_val ^= ord(ch)

    return chr(chr_val)


# ------------------ Test (Same as Java main) ------------------

print(find_the_difference("acd", "aedc"))  # Expected: 'e'
