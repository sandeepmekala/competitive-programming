"""
L567 - Permutation in String

Problem: https://leetcode.com/problems/permutation-in-string/
Idea: Compare the frequency. Load first m chars to respective maps and compare.
Then subsequently remove last char from s2 and load new char and compare everytime.
Time: O(n)
Space: O(1) - constant space for character frequencies
"""

def check_inclusion(s1, s2):
    m, n = len(s1), len(s2)
    if m > n:
        return False
    
    s1_map = {}
    s2_map = {}
    
    # Initialize frequency maps for first window
    for i in range(m):
        s1_ch = s1[i]
        s1_map[s1_ch] = s1_map.get(s1_ch, 0) + 1
        s2_ch = s2[i]
        s2_map[s2_ch] = s2_map.get(s2_ch, 0) + 1
    
    if matching(s1_map, s2_map):
        return True
    
    # Slide the window
    for r in range(m, n):
        l = r - m
        # Add new character
        r_ch = s2[r]
        s2_map[r_ch] = s2_map.get(r_ch, 0) + 1
        # Remove old character
        l_ch = s2[l]
        s2_map[l_ch] = s2_map[l_ch] - 1
        
        if matching(s1_map, s2_map):
            return True
    
    return False


def matching(s1_map, s2_map):
    for key in s1_map:
        if s1_map[key] - s2_map.get(key, 0) != 0:
            return False
    return True


if __name__ == "__main__":
    s1 = "ab"
    s2 = "eidbaooo"
    print(f"Input: s1 = '{s1}', s2 = '{s2}'")
    print(f"Output: {check_inclusion(s1, s2)}")
