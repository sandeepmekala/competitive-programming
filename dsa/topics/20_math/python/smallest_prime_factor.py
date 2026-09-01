# Time complexity: O(q * log(n))
def smallest_prime_factor(queries):
    primes = get_smallest_prime_factors(int(1e6))

    ans = []
    for n in queries:
        factors = []
        while n > 1:
            factors.append(primes[n])
            n = n // primes[n]
        ans.append(factors)

    return ans


# Time complexity: O(n * log(log(n)))
def get_smallest_prime_factors(n):
    prime = [i for i in range(n + 1)]

    i = 2
    while i * i <= n:
        if prime[i] == i:
            j = i * i
            while j <= n:
                if prime[j] == j:
                    prime[j] = i
                j += i
        i += 1

    return prime


# ------------------ Test (Same as Java main) ------------------

print(smallest_prime_factor([315, 16]))  
# Expected: [[3, 3, 5, 7], [2, 2, 2, 2]]
