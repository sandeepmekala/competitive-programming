# Problem: https://leetcode.com/problems/repeated-substring-pattern/
# Idea: Construct lps array. Incase of repeated substrings, the lps will be
# continuously increasing from second repeated substring.
# The n-1th lps should be divisible by repeating substring length.
def repeated_substring_pattern(s):
    n = len(s)
    lps = [0] * n
    i = 1
    j = 0

    while i < n:
        if s[i] == s[j]:
            lps[i] = j + 1
            i += 1
            j += 1
        else:
            if j > 0:
                j = lps[j - 1]
            else:
                lps[i] = 0
                i += 1

    # If lps[n-1] == 0, no repeating pattern exists
    if lps[n - 1] == 0:
        return False

    l = lps[n - 1]
    return l % (n - l) == 0


# ------------------ Test (Same as Java main) ------------------

s = "abcabcabcabc"
print(repeated_substring_pattern(s))  # Expected: True
