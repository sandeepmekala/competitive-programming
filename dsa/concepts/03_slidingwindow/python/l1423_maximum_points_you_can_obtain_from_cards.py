"""
L1423 - Maximum Points You Can Obtain from Cards

Problem: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
Idea: Use sliding window approach. Start by taking k cards from left, then gradually replace 
leftmost cards with rightmost cards to find maximum sum.
Time: O(k)
Space: O(1)
"""

def max_score(card_points, k):
    n = len(card_points)
    current_sum = 0
    max_sum = 0
    
    # Calculate sum of first k cards
    for i in range(k):
        current_sum += card_points[i]
    max_sum = current_sum
    
    # Try replacing cards from left with cards from right
    l, r = k - 1, n - 1
    while l >= 0:
        current_sum -= card_points[l]
        current_sum += card_points[r]
        l -= 1
        r -= 1
        
        max_sum = max(max_sum, current_sum)
    
    return max_sum


if __name__ == "__main__":
    card_points = [1, 2, 3, 4, 5, 6, 1]
    k = 3
    print(f"Input: cardPoints = {card_points}, k = {k}")
    print(f"Output: {max_score(card_points, k)}")
