"""
Aggressive Cows (SPOJ)

Problem:
https://www.spoj.com/problems/AGGRCOW/

Idea:
Binary Search on the answer (minimum distance).
Check feasibility using greedy placement.

Time Complexity: O(n log n)
Space Complexity: O(1)
"""

def can_place(stalls, cows, min_dist):
    count = 1
    last_pos = stalls[0]

    for pos in stalls[1:]:
        if pos - last_pos >= min_dist:
            count += 1
            last_pos = pos
            if count == cows:
                return True

    return False


def place_cows(stalls, cows):
    stalls.sort()
    n = len(stalls)

    low, high = 1, stalls[-1] - stalls[0]
    ans = -1

    while low <= high:
        mid = (low + high) // 2

        if can_place(stalls, cows, mid):
            ans = mid
            low = mid + 1   # try for a bigger minimum distance
        else:
            high = mid - 1  # reduce distance

    return ans


# Driver code
if __name__ == "__main__":
    stalls = [1, 2, 8, 4, 9]
    cows = 3
    print(place_cows(stalls, cows))
