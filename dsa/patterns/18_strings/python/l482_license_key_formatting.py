# Problem: https://leetcode.com/problems/license-key-formatting/
# Idea: Go right to left as first group can have less chars.
def license_key_formatting(s, k):
    sb = []
    count = 0

    for i in range(len(s) - 1, -1, -1):
        ch = s[i]
        if ch == '-':
            continue

        if count == k:
            sb.append('-')
            count = 0

        sb.append(ch.upper())
        count += 1

    return "".join(reversed(sb))


# ------------------ Test (Same as Java main) ------------------

s = "5F3Z-2e-9-w"
print(license_key_formatting(s, 4))  # Expected: "5F3Z-2E9W"
