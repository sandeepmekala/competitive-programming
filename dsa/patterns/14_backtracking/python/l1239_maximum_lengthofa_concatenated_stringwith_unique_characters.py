# Problem: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
# Idea:
# Use backtracking (pick / not-pick).
# Maintain a set of used characters.
# At each index:
#   - Pick current string if it has no overlap with existing characters
#   - Or skip it
# Return max length possible.
# Time: O(2^n * k) where k is max string length
# Space: O(k)

def maxLength(arr):
    used = set()
    return backtrack(arr, 0, used)


def backtrack(arr, ind, used):
    if ind == len(arr):
        return len(used)

    pick = 0
    if not overlap(used, arr[ind]):
        for ch in arr[ind]:
            used.add(ch)

        pick = backtrack(arr, ind + 1, used)

        for ch in arr[ind]:
            used.remove(ch)   # backtracking

    not_pick = backtrack(arr, ind + 1, used)

    return max(pick, not_pick)


def overlap(used, s):
    local = set()
    for ch in s:
        if ch in used or ch in local:
            return True
        local.add(ch)
    return False


# -------- Test --------
arr = ["un", "iq", "ue"]
print(maxLength(arr))
# Expected: 4  ("uniq" or "ique")
