# Problem: https://leetcode.com/problems/decode-ways/
def numDecodings(s: str) -> int:
    n = len(s)

    if s.startswith("0"):
        return 0
    if n == 1:
        return 1

    dp = [0] * n
    dp[0] = 1

    num = s[0:2]

    if s[1] == '0':
        if s[0] == '1' or s[0] == '2':
            dp[1] = 1
        else:
            return 0
    elif num > "26" or num < "10":
        dp[1] = 1
    elif num > "10" and num <= "26":
        dp[1] = 2

    for i in range(2, n):
        num = s[i-1:i+1]

        if s[i] == '0':
            if s[i-1] == '1' or s[i-1] == '2':
                dp[i] = dp[i-2]
            else:
                return 0
        elif num > "26" or num < "10":
            dp[i] = dp[i-1]
        elif num > "10" and num <= "26":
            dp[i] = dp[i-1] + dp[i-2]

    return dp[n-1]


# -------- Test (same as Java main) --------
print(numDecodings("06"))
