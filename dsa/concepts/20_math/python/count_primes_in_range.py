# Time complexity (queries): O(q)
# Preprocessing with sieve: O(n * log(log n))

def countPrimesInRange(queries):
    MAXN = 10**6
    primes = getPrimes(MAXN)

    # prefix sum sieve
    cnt = 0
    for i in range(len(primes)):
        cnt += primes[i]
        primes[i] = cnt

    ans = []
    for l, r in queries:
        if l > 0:
            ans.append(primes[r] - primes[l - 1])
        else:
            ans.append(primes[r])
    return ans


# Time complexity: O(n * log(log n))
def getPrimes(n):
    prime = [1] * (n + 1)
    prime[0] = prime[1] = 0

    i = 2
    while i * i <= n:
        if prime[i] == 1:
            for j in range(i * i, n + 1, i):
                prime[j] = 0
        i += 1

    return prime


# -------- Test --------
queries = [(10, 30), (5, 32)]
print(countPrimesInRange(queries))   # [6, 9]
