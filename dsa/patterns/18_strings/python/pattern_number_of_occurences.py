# Problem: Conventional pattern matching with 2 loops.
def find_pattern(input_str, pattern):
    n = len(input_str)
    m = len(pattern)

    for i in range(n - m + 1):
        j = 0
        for j in range(m):
            if input_str[i + j] != pattern[j]:
                break
        if j == m - 1 and input_str[i + j] == pattern[j]:
            print("Pattern found at:", i)


# ------------------ Test (Same as Java main) ------------------

input_str = "AABAACAADAABAABA"
pattern = "AABA"
find_pattern(input_str, pattern)
