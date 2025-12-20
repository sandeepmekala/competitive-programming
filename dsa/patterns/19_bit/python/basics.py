def print_binary_iteratively(n):
    sb = []
    while n > 0:
        sb.append(str(n % 2))
        n = n // 2
    print("".join(reversed(sb)))


def print_binary_recursively(n):
    if n > 0:
        print_binary_recursively(n // 2)
    print(n % 2, end="")


def print_binary_recursively_with_right_shift(n):
    if n > 0:
        print_binary_recursively(n >> 1)
    print(n & 1, end="")


# ------------------ Test (Same as Java main) ------------------

# Binary iteratively
print_binary_iteratively(4)

# Binary recursively
print_binary_recursively(4)
print()

# Binary recursively with right shift
print_binary_recursively_with_right_shift(4)
print()

# Get the rightmost set bit
x = 100
print(bin(x)[2:])        # 1100100
print(x & ~(x - 1))      # 4 -> 0000100
