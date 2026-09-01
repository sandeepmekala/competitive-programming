# Problem: Generate Power Set of a string
# Idea (Recursive):
# At each index, we have two choices:
# 1. Pick the current character
# 2. Not pick the current character
# When index reaches string length, print/store the result

def solve(i, s, f, result):
    if i == len(s):
        result.append(f)
        return

    # picking
    solve(i + 1, s, f + s[i], result)

    # not picking (backtracking happens automatically as strings are immutable)
    solve(i + 1, s, f, result)


# Iterative approach using bit masking
# Idea:
# For string length n, there are 2^n subsets
# Each number from 0 to (2^n - 1) represents a subset
# If ith bit is set, include s[i]

def all_possible_strings(s):
    n = len(s)
    ans = []

    for num in range(1 << n):
        sub = ""
        for i in range(n):
            # check if ith bit is set
            if num & (1 << i):
                sub += s[i]
        ans.append(sub)

    ans.sort()
    return ans


# -------- Test --------
s = "abc"

# Recursive
res = []
solve(0, s, "", res)
print("Recursive:", res)

# Iterative
print("Iterative:", all_possible_strings(s))
