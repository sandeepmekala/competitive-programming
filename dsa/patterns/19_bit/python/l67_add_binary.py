# Problem: https://leetcode.com/problems/add-binary/
# Idea: You can use normal number addition technique of num1, num2 and carry.
# You can shift right the sum to get new carry.
def add_binary(a, b):
    sb = []
    carry = 0
    i = len(a) - 1
    j = len(b) - 1

    while i >= 0 or j >= 0 or carry != 0:
        num1 = ord(a[i]) - ord('0') if i >= 0 else 0
        num2 = ord(b[j]) - ord('0') if j >= 0 else 0
        i -= 1
        j -= 1

        s = num1 + num2 + carry

        if (s & 1) > 0:
            sb.append('1')
        else:
            sb.append('0')

        carry = s >> 1     # point

    return "".join(reversed(sb))


# ------------------ Test (Same as Java main) ------------------

a = "1010"
b = "1011"
print(add_binary(a, b))  # Expected: "10101"
