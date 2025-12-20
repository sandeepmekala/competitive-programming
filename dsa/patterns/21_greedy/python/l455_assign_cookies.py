# Problem: https://leetcode.com/problems/assign-cookies/
# Idea: Greedy: Assign the cookie to the child who has least greed factor
# and can be satisfied with the cookie.
# Time: O(n log n)

def findContentChildren(g, s):
    g.sort()
    s.sort()

    l = r = 0
    m, n = len(g), len(s)

    while l < m and r < n:
        if g[l] <= s[r]:
            l += 1      # child is satisfied
        r += 1          # move to next cookie

    return l


# -------- Test --------
print(findContentChildren([1, 2, 3], [1, 1]))   # Expected: 1
