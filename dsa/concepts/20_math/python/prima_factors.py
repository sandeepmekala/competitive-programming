# Time complexity: O(sqrt(n) * log(n))
def prime_factors(n):
    factors = []

    i = 2
    while i * i < n:
        if n % i == 0:
            factors.append(i)
            while n % i == 0:
                n = n // i
        i += 1

    # if we run till sqrt(n) then n can be prime number factor
    if n > 1:
        factors.append(n)

    return factors


# ------------------ Test (Same as Java main) ------------------

print(prime_factors(315))  # Expected: [3, 5, 7]
print(prime_factors(16))   # Expected: [2]
