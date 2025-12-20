# Problem: https://leetcode.com/problems/valid-palindrome-ii/
# Idea: Check polindrome from both sides. Once miss match happens,
# prepare 2 strings ignoring left and right chars and check if they are polindromes.
def valid_palindrome(s):
    l = 0
    r = len(s) - 1

    while l < r:
        if s[l] == s[r]:
            l += 1
            r -= 1
        else:
            return (is_valid_palindrome(s[l + 1:r + 1]) or
                    is_valid_palindrome(s[l:r]))

    return True


def is_valid_palindrome(s):
    l = 0
    r = len(s) - 1

    while l < r:
        if s[l] != s[r]:
            return False
        l += 1
        r -= 1

    return True


# ------------------ Test (Same as Java main) ------------------

s = "abca"
print(valid_palindrome(s))  # Expected: True
