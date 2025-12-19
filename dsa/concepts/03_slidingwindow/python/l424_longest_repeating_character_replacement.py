"""
L424 - Longest Repeating Character Replacement

Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
Idea: Replace k chars to get longest repeating char substring.
In a substring we will try to replace all characters except the max frequency chars.
maxFreq is the max frequency of any character in the window
(r-l+1) - maxFreq is the number of characters we need to replace
Ideally maxFreq need to reduced after every window shrink. But there is no point in reducing maxFreq.
Because increased maxFreq will give us better maxLen. Reducing will not help. Hence, we are not reducing maxFreq.
Time: O(n)
Space: O(1)
"""

def character_replacement(s, k):
    char_map = [0] * 26  # For uppercase letters A-Z
    l, r, max_len, max_freq, n = 0, 0, 0, 0, len(s)
    
    while r < n:
        char_map[ord(s[r]) - ord('A')] += 1
        max_freq = max(max_freq, char_map[ord(s[r]) - ord('A')])
        
        if (r - l + 1) - max_freq > k:
            char_map[ord(s[l]) - ord('A')] -= 1  # not updating max_freq
            l += 1
        
        if (r - l + 1) - max_freq <= k:
            max_len = max(max_len, r - l + 1)
        
        r += 1
    
    return max_len


if __name__ == "__main__":
    s = "AABABBA"
    k = 1
    print(f"Input: s = '{s}', k = {k}")
    print(f"Output: {character_replacement(s, k)}")
