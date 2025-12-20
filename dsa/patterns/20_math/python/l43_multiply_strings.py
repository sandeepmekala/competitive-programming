# Problem: https://leetcode.com/problems/multiply-strings/
# Idea: The important thing to remember is when we multiply num1[i] * num2[j]
# the result will be placed at indices [i + j], [i + j + 1].
# Create a temp pos array to track multiplication results and carries
# and convert it String at the end.
def multiply(num1, num2):
    m, n = len(num1), len(num2)

    num1 = num1[::-1]   # reverse
    num2 = num2[::-1]

    pos = [0] * (m + n)

    for i in range(n):
        for j in range(m):
            mul = (ord(num2[i]) - ord('0')) * (ord(num1[j]) - ord('0'))
            ind = i + j

            pos[ind] += mul
            carry = pos[ind] // 10
            pos[ind] %= 10
            pos[ind + 1] += carry

    sb = []
    for i in range(len(pos) - 1, -1, -1):
        if not sb and pos[i] == 0:   # skip leading zeros
            continue
        sb.append(str(pos[i]))

    if not sb:
        return "0"

    return "".join(sb)


# ------------------ Test (Same as Java main) ------------------

print(multiply("9", "91"))   # Expected: "819"
