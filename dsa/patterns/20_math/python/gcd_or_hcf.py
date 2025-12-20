# Euclidean algorithm
# gcd(a, b) = gcd(a-b, b) = gcd(a % b, b) if a > b
# GCD / HCF = Greatest Common Divisor / Highest Common Factor
# Time: O(log(min(a, b)))
# Space: O(1)

def gcd(a, b):
    while a > 0 and b > 0:
        if a > b:
            a = a % b
        else:
            b = b % a

    return b if a == 0 else a


# -------- Test --------
print(gcd(4, 6))    # 2
