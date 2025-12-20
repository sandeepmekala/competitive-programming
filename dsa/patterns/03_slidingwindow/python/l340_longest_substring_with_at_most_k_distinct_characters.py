"""
L340 - Longest Substring with At Most K Distinct Characters

Problem: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
Idea: Use sliding window with hashmap to track character frequencies.
Expand window by adding characters, shrink when distinct characters exceed k.
Time: O(n)
Space: O(k)
"""

def length_of_longest_substring_k_distinct(s, k):
    char_map = {}
    n = len(s)
    l, r, max_len = 0, 0, 0
    
    while r < n:
        ch = s[r]
        char_map[ch] = char_map.get(ch, 0) + 1
        
        if len(char_map) > k:
            t = s[l]
            char_map[t] = char_map.get(t, 0) - 1
            if char_map[t] == 0:
                del char_map[t]
            l += 1
        
        if len(char_map) <= k:
            max_len = max(max_len, r - l + 1)
        
        r += 1
    
    return max_len


if __name__ == "__main__":
    s = "eceba"
    k = 2
    print(f"Input: s = '{s}', k = {k}")
    print(f"Output: {length_of_longest_substring_k_distinct(s, k)}")
