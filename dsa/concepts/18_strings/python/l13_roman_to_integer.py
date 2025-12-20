# Problem: https://leetcode.com/problems/roman-to-integer/
# Idea: Move left to right. For every roman char add its value to num.
# Incase, roman chars C,X,I check next char, if it is higher then it,
# then subtract its value from num. I could have V or X as its right char.
def roman_to_int(s):
    num = 0
    n = len(s)

    for i in range(n):
        ch = s[i]

        if ch == 'M':
            num += 1000
        elif ch == 'D':
            num += 500
        elif ch == 'C':
            if i + 1 < n and (s[i + 1] == 'D' or s[i + 1] == 'M'):
                num -= 100
            else:
                num += 100
        elif ch == 'L':
            num += 50
        elif ch == 'X':
            if i + 1 < n and (s[i + 1] == 'L' or s[i + 1] == 'C'):
                num -= 10
            else:
                num += 10
        elif ch == 'V':
            num += 5
        elif ch == 'I':
            if i + 1 < n and (s[i + 1] == 'V' or s[i + 1] == 'X'):
                num -= 1
            else:
                num += 1

    return num


# ------------------ Test (Same as Java main) ------------------

s = "MCMXCIV"
print(roman_to_int(s))  # Expected: 1994
