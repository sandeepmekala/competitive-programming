"""
L1010 - Pairs of Songs With Total Durations Divisible by 60

Problem: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
Idea: Similar like Two sum
Time: O(n) where n is length of time array
Space: O(1) - at most 60 different remainders
"""

def num_pairs_divisible_by_60(time):
    remainder_count = {}
    count = 0
    
    for duration in time:
        remainder = duration % 60
        complement = (60 - remainder) % 60
        
        # If complement exists, add its count to result
        if complement in remainder_count:
            count += remainder_count[complement]
        
        # Update count for current remainder
        remainder_count[remainder] = remainder_count.get(remainder, 0) + 1
    
    return count

if __name__ == "__main__":
    time = [30, 20, 150, 100, 40]
    print(f"Input: {time}")
    print(f"Output: {num_pairs_divisible_by_60(time)}")
