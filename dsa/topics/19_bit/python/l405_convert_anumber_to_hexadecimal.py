# Problem: https://leetcode.com/problems/convert-a-number-to-hexadecimal/
# Companies: Facebook
# Idea: Take a rem by dividing 15 and get corresponding rem chars.
# As num be negative use n!=0 as while condition
# Use >>> instead of >> as we need to convert lsb bits also.
def to_hex(num):
    if num == 0:
        return "0"

    sb = []
    num &= 0xffffffff   # ensure 32-bit unsigned behavior

    while num != 0:
        rem = num & 15   # or num % 16
        if rem < 10:
            sb.append(str(rem))
        else:
            sb.append(chr(ord('a') + rem - 10))

        num = num >> 4   # logical right shift after masking

    return "".join(reversed(sb))


# ------------------ Test (Same as Java main) ------------------

print(to_hex(26))    # Expected: "1a"
print(to_hex(-26))   # Expected: "ffffffe6"

print(bin(-26 & 0xffffffff)[2:])
print(bin((-26 >> 2) & 0xffffffff)[2:])     # arithmetic right shift effect
print(bin((-26 & 0xffffffff) >> 2)[2:])     # logical right shift effect
