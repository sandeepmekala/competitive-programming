# Problem: https://leetcode.com/problems/add-strings/
# Idea: while (i >= 0 || j >= 0 || carry != 0)
def add_strings(num1, num2):
    sb = []
    i = len(num1) - 1
    j = len(num2) - 1
    carry = 0

    while i >= 0 or j >= 0 or carry != 0:
        n1 = ord(num1[i]) - ord('0') if i >= 0 else 0
        n2 = ord(num2[j]) - ord('0') if j >= 0 else 0
        i -= 1
        j -= 1

        s = n1 + n2 + carry
        sb.append(str(s % 10))
        carry = s // 10

    return "".join(reversed(sb))


# ------------------ Test (Same as Java main) ------------------

print(add_strings("123", "456"))  # Expected: "579"
