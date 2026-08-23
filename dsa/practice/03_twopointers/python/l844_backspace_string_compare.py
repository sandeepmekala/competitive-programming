"""
L844 - Backspace String Compare
Problem: https://leetcode.com/problems/backspace-string-compare/
Idea: Come from back counting the # and skipping that many chars.
Time: O(n + m)
Space: O(1)
"""

def backspace_compare(s, t):
    """
    Compare two strings after processing backspaces.
    
    Args:
        s: str - First string with possible backspaces (#)
        t: str - Second string with possible backspaces (#)
    
    Returns:
        bool - True if strings are equal after processing backspaces
    """
    count1 = count2 = 0
    i, j = len(s) - 1, len(t) - 1
    
    while i >= 0 or j >= 0:
        # Process string s from right to left
        while i >= 0:
            if s[i] == '#':
                count1 += 1
                i -= 1
            elif count1 > 0:
                count1 -= 1
                i -= 1
            else:
                break
        
        # Process string t from right to left
        while j >= 0:
            if t[j] == '#':
                count2 += 1
                j -= 1
            elif count2 > 0:
                count2 -= 1
                j -= 1
            else:
                break
        
        # Compare current characters
        if i >= 0 and j >= 0 and s[i] != t[j]:
            return False
        if (i < 0 and j >= 0) or (i >= 0 and j < 0):
            return False
        
        i -= 1
        j -= 1
    
    return True


if __name__ == "__main__":
    s = "bxj##tw"
    t = "bxo#j##tw"
    result = backspace_compare(s, t)
    print(result)  # Expected: True
