# DP / Partition DP
#
# Evaluate Boolean Expression to True
#
# Given a boolean expression with symbols:
# T (true), F (false)
# Operators: &, |, ^
#
# Count the number of ways to parenthesize the expression
# such that it evaluates to TRUE.
#
# This is a classic Partition DP problem (similar to Matrix Chain Multiplication).

mod = 1000000007


def evaluateexp(exp):
    n = len(exp)

    # dp[i][j][isTrue]
    # isTrue = 1 -> number of ways expression[i..j] evaluates to True
    # isTrue = 0 -> number of ways expression[i..j] evaluates to False
    dp = [[[0, 0] for _ in range(n)] for _ in range(n)]

    for i in range(n - 1, -1, -1):
        for j in range(n):
            # Base case 1:
            if i > j:
                continue

            for isTrue in range(2):
                # Base case 2:
                if i == j:
                    if isTrue == 1:
                        dp[i][j][isTrue] = 1 if exp[i] == 'T' else 0
                    else:
                        dp[i][j][isTrue] = 1 if exp[i] == 'F' else 0
                    continue

                # recurrence logic:
                ways = 0
                for ind in range(i + 1, j, 2):
                    lT = dp[i][ind - 1][1]
                    lF = dp[i][ind - 1][0]
                    rT = dp[ind + 1][j][1]
                    rF = dp[ind + 1][j][0]

                    if exp[ind] == '&':
                        if isTrue == 1:
                            ways = (ways + (lT * rT) % mod) % mod
                        else:
                            ways = (ways + (lF * rT) % mod +
                                    (lT * rF) % mod +
                                    (lF * rF) % mod) % mod

                    elif exp[ind] == '|':
                        if isTrue == 1:
                            ways = (ways + (lF * rT) % mod +
                                    (lT * rF) % mod +
                                    (lT * rT) % mod) % mod
                        else:
                            ways = (ways + (lF * rF) % mod) % mod

                    else:  # '^'
                        if isTrue == 1:
                            ways = (ways + (lF * rT) % mod +
                                    (lT * rF) % mod) % mod
                        else:
                            ways = (ways + (lF * rF) % mod +
                                    (lT * rT) % mod) % mod

                dp[i][j][isTrue] = ways

    return dp[0][n - 1][1]


def evaluateexp2(exp):
    n = len(exp)
    return evaluateexp2Helper(0, n - 1, 1, exp)


def evaluateexp2Helper(i, j, isTrue, exp):
    # Base case 1:
    if i > j:
        return 0

    # Base case 2:
    if i == j:
        if isTrue == 1:
            return 1 if exp[i] == 'T' else 0
        else:
            return 1 if exp[i] == 'F' else 0

    ways = 0
    for ind in range(i + 1, j, 2):
        lT = evaluateexp2Helper(i, ind - 1, 1, exp)
        lF = evaluateexp2Helper(i, ind - 1, 0, exp)
        rT = evaluateexp2Helper(ind + 1, j, 1, exp)
        rF = evaluateexp2Helper(ind + 1, j, 0, exp)

        if exp[ind] == '&':
            if isTrue == 1:
                ways = (ways + (lT * rT) % mod) % mod
            else:
                ways = (ways + (lF * rT) % mod +
                        (lT * rF) % mod +
                        (lF * rF) % mod) % mod

        elif exp[ind] == '|':
            if isTrue == 1:
                ways = (ways + (lF * rT) % mod +
                        (lT * rF) % mod +
                        (lT * rT) % mod) % mod
            else:
                ways = (ways + (lF * rF) % mod) % mod

        else:  # '^'
            if isTrue == 1:
                ways = (ways + (lF * rT) % mod +
                        (lT * rF) % mod) % mod
            else:
                ways = (ways + (lF * rF) % mod +
                        (lT * rT) % mod) % mod

    return ways


# -------- Test --------
exp = "F|T^F"
print(evaluateexp(exp))   # Expected: 2
print(evaluateexp2(exp))  # Expected: 2
