# Problem: https://leetcode.com/problems/count-primes/
# Companies: Amazon
# Idea: For each i from 2 to n and mark all the multiples of i as not primes in an array.
# Repeat the same for every not marked i.
# Sieve of Eratosthenes Algorithm
def count_primes(n):
    prime = [1] * (n + 1)

    i = 2
    while i * i <= n:
        if prime[i] == 1:
            j = i * i
            while j <= n:
                prime[j] = 0
                j += i
        i += 1

    count = 0
    for i in range(2, n):
        if prime[i] == 1:
            count += 1

    return count


# ------------------ Test (Same as Java main) ------------------

print(count_primes(10))  # Expected: 4
