# L997 - Find the Town Judge
#
# Problem: https://leetcode.com/problems/find-the-town-judge/
#
# Idea:
# - Maintain two arrays:
#   1. truster[i]: number of people person i trusts
#   2. trusted[i]: number of people who trust person i
# - Judge trusts nobody → truster[judge] == 0
# - Everyone else trusts judge → trustee[judge] == n - 1
#
# Time: O(n + len(trust))
# Space: O(n)


def find_judge(n, trust):
    truster = [0] * (n + 1)
    trusted = [0] * (n + 1)

    for a, b in trust:
        truster[a] += 1
        trusted[b] += 1

    for person in range(1, n + 1):
        if truster[person] == 0 and trusted[person] == n - 1:
            return person

    return -1


# -------------------- TEST --------------------
if __name__ == "__main__":
    n = 3
    trust = [[1, 3], [2, 3]]
    print(find_judge(n, trust))  # Output: 3
