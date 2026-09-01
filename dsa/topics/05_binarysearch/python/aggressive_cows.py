# Aggressive Cows (SPOJ)
#
# Problem:
# https://www.spoj.com/problems/AGGRCOW/
#
# Idea:
# Binary Search on the answer (minimum distance).
# Check feasibility using greedy placement.
#
# Time Complexity: O(n log n)
# Space Complexity: O(1)

def can_place(stalls: list[int], cows: int, min_dist: int) -> bool:
    count = 1
    last_position = stalls[0]

    for position in stalls[1:]:
        if position - last_position >= min_dist:
            count += 1
            last_position = position
            if count == cows:
                return True

    return False


def place_cows(stalls: list[int], cows: int) -> int:
    stalls.sort()

    left, right = 1, stalls[-1] - stalls[0]
    ans = -1

    while left <= right:
        mid = (left + right) // 2

        if can_place(stalls, cows, mid):
            ans = mid
            left = mid + 1   # try for a bigger minimum distance
        else:
            right = mid - 1  # reduce distance

    return ans


# Driver code
if __name__ == "__main__":
    stalls = [1, 2, 8, 4, 9]
    cows = 3
    print(place_cows(stalls, cows))  # 3
