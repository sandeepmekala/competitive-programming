"""
LeetCode 1482 - Minimum Number of Days to Make m Bouquets

Idea:
Binary search on the number of days.
- Minimum possible day = min(bloomDay)
- Maximum possible day = max(bloomDay)

For a given day D, check if we can make at least m bouquets,
each requiring k adjacent flowers that have bloomed by day D.

Time Complexity: O(n log(max(bloomDay) - min(bloomDay)))
Space Complexity: O(1)
"""

def can_make(bloom_day, day, m, k):
    consecutive = 0
    bouquets = 0

    for b in bloom_day:
        if b <= day:
            consecutive += 1
        else:
            bouquets += consecutive // k
            consecutive = 0

    bouquets += consecutive // k
    return bouquets >= m


def min_days(bloom_day, m, k):
    n = len(bloom_day)

    # Impossible case
    if n < m * k:
        return -1

    low, high = min(bloom_day), max(bloom_day)
    ans = high

    while low <= high:
        mid = (low + high) // 2

        if can_make(bloom_day, mid, m, k):
            ans = mid
            high = mid - 1   # try earlier day
        else:
            low = mid + 1    # need more days

    return ans


# Driver code
if __name__ == "__main__":
    bloom_day = [1, 10, 3, 10, 2]
    m, k = 3, 1
    print(min_days(bloom_day, m, k))  # 3
