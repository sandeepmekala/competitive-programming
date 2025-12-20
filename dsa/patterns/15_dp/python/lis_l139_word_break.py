# Problem: https://leetcode.com/problems/word-break/
#
def wordBreak(s, wordDict):
    words = set(wordDict)
    n = len(s)
    dp = [False] * (n + 1)
    dp[0] = True                   # empty string

    for i in range(1, n + 1):
        for j in range(i):
            if dp[j] and s[j:i] in words:
                dp[i] = True
                break

    return dp[n]


# -------- Test (same as Java main) --------
s = "leetcode"
wordDict = ["leet", "code"]
print(wordBreak(s, wordDict))
