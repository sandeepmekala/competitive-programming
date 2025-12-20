def longest_consecutive_characters(sequence):
    max_count = 0
    max_char = ''

    curr = ''
    prev = ''
    count = 0

    for i in range(len(sequence)):
        curr = sequence[i]

        if prev == curr:
            count += 1
            if count > max_count:
                max_char = curr
                max_count = count
        else:
            count = 1

        prev = curr

    return f"{max_char}:{max_count}"


# ------------------ Test (Same as Java main) ------------------

sequence = "AABCDAADBBBEA"
print(longest_consecutive_characters(sequence))  # Expected: B:3
