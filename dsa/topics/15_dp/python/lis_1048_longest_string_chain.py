# Problem: https://leetcode.com/problems/longest-string-chain/
# Idea: Similar like lis, and lds. Instead of checking for increasbility/divisibility check chain validity.
def longestStrChain(words):
    n = len(words)
    if n <= 1:
        return n

    words.sort(key=len)
    lsc = [1] * n

    max_len = 0
    for i in range(1, n):
        for j in range(i):
            if checkPossible(words[i], words[j]):
                if lsc[j] + 1 > lsc[i]:
                    lsc[i] = 1 + lsc[j]
        if lsc[i] > max_len:
            max_len = lsc[i]

    return max_len


def checkPossible(s1, s2):
    if len(s1) != len(s2) + 1:
        return False

    i = j = 0
    while i < len(s1):
        if j < len(s2) and s1[i] == s2[j]:
            i += 1
            j += 1
        else:
            i += 1

    return i == len(s1) and j == len(s2)


# -------- Test (same as Java main) --------
words = ["xbc", "pcxbcf", "xb", "cxbc", "pcxbc"]
print(longestStrChain(words))
