"""
LeetCode 1011 - Capacity To Ship Packages Within D Days

Idea:
Binary search on ship capacity.
- Minimum capacity = max(weights)
- Maximum capacity = sum(weights)

For a guessed capacity, compute how many days are needed.
If days <= D, try smaller capacity.
Else, increase capacity.

Time Complexity: O(n log(sum(weights)))
Space Complexity: O(1)
"""

def days_required(weights, capacity):
    days = 1
    load = 0

    for wt in weights:
        if load + wt > capacity:
            days += 1
            load = 0
        load += wt

    return days


def ship_within_days(weights, D):
    low = max(weights)      # at least the heaviest package
    high = sum(weights)     # at most all packages in one day
    ans = high

    while low <= high:
        mid = (low + high) // 2

        if days_required(weights, mid) <= D:
            ans = mid
            high = mid - 1   # try smaller capacity
        else:
            low = mid + 1    # need larger capacity

    return ans


# Driver code
if __name__ == "__main__":
    weights = [1,2,3,4,5,6,7,8,9,10]
    D = 5
    print(ship_within_days(weights, D))  # 15
