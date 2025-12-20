# Problem: https://leetcode.com/problems/longest-uncommon-subsequence-i/
# Companies: Amazon, Google, Facebook
# Idea: If two string are equal, means every subseq of str1 is a subsequence of str2.
# If strings are not equal, the max len string subsequence is itself and it can't be there in other string.
def find_lus_length(a, b):
    return -1 if a == b else max(len(a), len(b))


# ------------------ Test (Same as Java main) ------------------

print(find_lus_length("abc", "aaaaa"))  # Expected: 5
