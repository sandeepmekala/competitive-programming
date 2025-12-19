"""
L1358 - Number of Substrings Containing All Three Characters

Problem: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
Idea: Track the last seen index of each character. If all characters are seen at least once, 
then the number of substrings ending at that index is min of last seen index of all characters + 1
Time: O(n)
Space: O(1)
"""

def number_of_substrings(s):
    n, r, count = len(s), 0, 0
    last_seen = [-1, -1, -1]  # For characters 'a', 'b', 'c'
    
    while r < n:
        last_seen[ord(s[r]) - ord('a')] = r
        
        if last_seen[0] != -1 and last_seen[1] != -1 and last_seen[2] != -1:
            count += min(last_seen[0], last_seen[1], last_seen[2]) + 1
        
        r += 1
    
    return count


if __name__ == "__main__":
    s = "abcabc"
    print(f"Input: s = '{s}'")
    print(f"Output: {number_of_substrings(s)}")
