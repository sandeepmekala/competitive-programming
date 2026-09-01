# Problem: https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
# Idea: Count the num freq and find the gcd of all freqeuncies to find x.
# {1,1,1,1,2,2} in this case x should be 2 which gcd(4,2).
# Hence, it can be grouped as [1,1], [1,1], [2,2]
def has_groups_size_x(deck):
    freq = {}
    for num in deck:
        freq[num] = freq.get(num, 0) + 1

    res = 0
    for count in freq.values():
        res = gcd(res, count)

    return res > 1


def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


# ------------------ Test (Same as Java main) ------------------

deck = [1, 2, 3, 4, 4, 3, 2, 1]
print(has_groups_size_x(deck))  # Expected: True
