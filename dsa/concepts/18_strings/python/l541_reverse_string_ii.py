# Problem: https://leetcode.com/problems/reverse-string-ii/
# Idea: Run i for every 2*k. Reverse string from i to i+k-1.
# Find min of i+k-1, n-1 as it can go out of bound.
def reverse_str(s, k):
    n = len(s)
    chars = list(s)

    for i in range(0, n, 2 * k):
        j = min(i + k - 1, n - 1)
        reverse(chars, i, j)

    return "".join(chars)


def reverse(chars, l, r):
    while l < r:
        chars[l], chars[r] = chars[r], chars[l]
        l += 1
        r -= 1


# ------------------ Test (Same as Java main) ------------------

print(reverse_str("abcdefg", 2))  # Expected: "bacdfeg"
