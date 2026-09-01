# Problem: https://leetcode.com/problems/binary-watch/
# Idea: Run 2 loops on hr and min. For hr and min, get bit count.
# If total bigcount = turnedOn, add that hr and min to list.
# Companies: Google
def read_binary_watch(turned_on):
    result = []

    for i in range(12):
        for j in range(60):
            hr_bits = i.bit_count()
            min_bits = j.bit_count()

            if hr_bits + min_bits == turned_on:
                if j < 10:
                    result.append(f"{i}:0{j}")
                else:
                    result.append(f"{i}:{j}")

    return result


# ------------------ Test (Same as Java main) ------------------

print(read_binary_watch(1))
