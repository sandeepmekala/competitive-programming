# Problem: https://leetcode.com/problems/longest-common-prefix/
# Idea: Compare all the strings with first string. Track min matching len.
def longest_common_prefix(strs):
    if not strs:
        return ""

    base = strs[0]
    min_len = len(base)

    for i in range(1, len(strs)):
        s = strs[i]
        length = 0
        for j in range(len(s)):
            if j < len(base) and base[j] == s[j]:
                length += 1
            else:
                break
        min_len = min(min_len, length)

    return base[:min_len]


# ------------------ Test (Same as Java main) ------------------

print(longest_common_prefix(["cir", "car"]))  # Expected: "c"
