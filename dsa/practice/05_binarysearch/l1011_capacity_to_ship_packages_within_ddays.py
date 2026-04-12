# LeetCode 1011 - Capacity To Ship Packages Within D Days
#
# Idea:
# Binary search on ship capacity.
# - Minimum capacity = max(weights)
# - Maximum capacity = sum(weights)
#
# For a guessed capacity, compute how many days are needed.
# If days <= D, try smaller capacity.
# Else, increase capacity.
#
# Time Complexity: O(n log(sum(weights)))
# Space Complexity: O(1)

def days_required(weights: list[int], capacity: int) -> int:
    days = 1
    current_load = 0

    for weight in weights:
        if current_load + weight > capacity:
            days += 1
            current_load = 0
        current_load += weight

    return days


def ship_within_days(weights: list[int], days_limit: int) -> int:
    left = max(weights)      # at least the heaviest package
    right = sum(weights)     # at most all packages in one day
    ans = right

    while left <= right:
        mid = (left + right) // 2

        if days_required(weights, mid) <= days_limit:
            ans = mid
            right = mid - 1   # try smaller capacity
        else:
            left = mid + 1    # need larger capacity

    return ans


# Driver code
if __name__ == "__main__":
    weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    D = 5
    print(ship_within_days(weights, D))  # 15
