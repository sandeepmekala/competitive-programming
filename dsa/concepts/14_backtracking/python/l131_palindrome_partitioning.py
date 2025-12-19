# Problem: https://leetcode.com/problems/palindrome-partitioning/
# Idea: Pass ind as a pointer in str. Starts with 0.
# Run a loop i, starts with ind and find a polindrome. And call the recursion
# to find subsequent polindromes with index as i+1.
# Time: O(n^n)
# Space: O(n)
def partition(s):
    result = []
    backtrack(s, 0, [], result)
    return result


def backtrack(s, ind, polindromes, result):
    if ind == len(s):
        result.append(polindromes.copy())
        return

    for i in range(ind, len(s)):
        if isPolindrome(s, ind, i):
            polindromes.append(s[ind:i+1])
            backtrack(s, i + 1, polindromes, result)
            polindromes.pop()      # backtracking


def isPolindrome(s, l, r):
    while l < r:
        if s[l] != s[r]:
            return False
        l += 1
        r -= 1
    return True


# -------- Test --------
s = "aab"
print(partition(s))
# Expected:
# [['a', 'a', 'b'], ['aa', 'b']]
