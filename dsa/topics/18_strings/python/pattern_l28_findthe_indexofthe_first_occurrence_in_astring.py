# Problem: https://leetcode.com/problems/implement-strstr/
# Companies: Google
# Idea: Use KMP search to find if the substring exist in the input,
# then return i-j.
def str_str(haystack, needle):
    if not needle:
        return 0

    lps = construct_lps(needle)
    i = 0
    j = 0
    n = len(haystack)

    while i < n:
        if haystack[i] == needle[j]:
            i += 1
            j += 1
            if j == len(needle):
                return i - j
        else:
            if j > 0:
                j = lps[j - 1]
            else:
                j = 0
                i += 1

    return -1


# Idea: Build lps array (Longest Prefix Suffix)
# lps[i] stores the length of the longest proper prefix
# which is also a suffix for pattern[0..i]
def construct_lps(pattern):
    m = len(pattern)
    lps = [0] * m
    i = 1
    j = 0

    while i < m:
        if pattern[i] == pattern[j]:
            lps[i] = j + 1
            i += 1
            j += 1
        else:
            if j > 0:
                j = lps[j - 1]
            else:
                i += 1

    return lps


# ------------------ Test (Same as Java main) ------------------

print(str_str("mississippi", "issip"))  # Expected: 4
