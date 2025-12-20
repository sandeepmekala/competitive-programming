# Problem: https://leetcode.com/problems/valid-palindrome/
# Idea: Convert string to lowercase. Move left and right ptrs. Skip
# non-alphanumeric.
def is_palindrome(s):
    s = s.lower()
    l = 0
    r = len(s) - 1

    while l < r:
        if not ('a' <= s[l] <= 'z' or '0' <= s[l] <= '9'):
            l += 1
            continue

        if not ('a' <= s[r] <= 'z' or '0' <= s[r] <= '9'):
            r -= 1
            continue

        if s[l] != s[r]:
            return False

        l += 1
        r -= 1

    return True


# ------------------ Test (Same as Java main) ------------------

s = "A man, a plan, a canal: Panama"
print(is_palindrome(s))  # Expected: True
