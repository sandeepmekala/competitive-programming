# Problem: https://leetcode.com/problems/partition-labels/
# Idea: Go greedy, have the last indices of each char.
# Pass1: While traversing the string char by char, store the last index of each char.
# Pass2: While iterating again, keep updating the farthest last index of characters seen so far.
# If current index reaches this farthest index, it means one partition is complete.
# Add partition size to result and reset size.

def partitionLabels(s):
    n = len(s)

    # last index of each character
    lastInd = {}
    for i, ch in enumerate(s):
        lastInd[ch] = i

    size = 0
    last = 0
    result = []

    for i, ch in enumerate(s):
        last = max(last, lastInd[ch])
        size += 1
        if i == last:
            result.append(size)
            size = 0

    return result


# -------- Test --------
s = "ababcbacadefegdehijhklij"
print(partitionLabels(s))   # [9, 7, 8]
