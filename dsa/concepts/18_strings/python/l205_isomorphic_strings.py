# Problem: https://leetcode.com/problems/isomorphic-strings/
# Idea: Create a mapping a->b if a is not in map and b is not already taken.
def is_isomorphic(s, t):
    mapping = {}
    used = set()

    for i in range(len(s)):
        sc = s[i]
        tc = t[i]

        if sc not in mapping and tc not in used:
            mapping[sc] = tc
            used.add(tc)

        if sc not in mapping and tc in used:
            return False
        if mapping.get(sc) != tc:
            return False

    return True


# ------------------ Test (Same as Java main) ------------------

s = "paper"
t = "title"
print(is_isomorphic(s, t))  # Expected: True
