# Idea: Similar like 3 is closely associated with 2, 7 is closely assiciated to 8.
# Multiplying n by 7 means, 7n = 8n - n
# 8 -> 2^3 which we can get by left shifting 3 times.
def multiply_by_7(n):
    return (n << 3) - n


# ------------------ Test (Same as Java main) ------------------

n = 2
print(multiply_by_7(n))  # Expected: 14
