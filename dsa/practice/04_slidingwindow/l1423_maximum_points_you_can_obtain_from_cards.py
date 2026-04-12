# L1423 - Maximum Points You Can Obtain from Cards
#
# Problem: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
# Idea: Use sliding window approach. Start by taking k cards from left, then gradually replace
# leftmost cards with rightmost cards to find maximum sum.
# Time: O(k)
# Space: O(1)

def max_score(card_points: list[int], k: int) -> int:
    n = len(card_points)

    # Calculate sum of first k cards
    curr_sum = sum(card_points[:k])
    max_sum = curr_sum

    # Try replacing cards from left with cards from right
    left = k - 1
    right = n - 1

    while left >= 0:
        curr_sum -= card_points[left]
        curr_sum += card_points[right]

        max_sum = max(max_sum, curr_sum)

        left -= 1
        right -= 1

    return max_sum


if __name__ == "__main__":
    card_points = [1, 2, 3, 4, 5, 6, 1]
    k = 3
    print(f"Input: cardPoints = {card_points}, k = {k}")
    print(f"Output: {max_score(card_points, k)}")
