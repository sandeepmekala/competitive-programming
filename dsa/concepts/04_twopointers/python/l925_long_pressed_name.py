"""
L925 - Long Pressed Name
Problem: https://leetcode.com/problems/long-pressed-name/
Idea: Use two pointers to compare the chars
Time: O(n + m)
Space: O(1)
"""

def is_long_pressed_name(name, typed):
    """
    Check if typed string could be the result of long pressing keys while typing name.
    
    Args:
        name: str - The intended name to type
        typed: str - The actual typed string
    
    Returns:
        bool - True if typed could be result of long pressing while typing name
    """
    i = j = 0
    m, n = len(name), len(typed)
    
    while i < m and j < n:
        if name[i] != typed[j]:
            return False
        
        ch = name[i]
        # Process all occurrences of current character in name
        while i < m and j < n and name[i] == ch:
            if name[i] != typed[j]:
                return False
            i += 1
            j += 1
        
        # Skip any extra occurrences of the same character in typed
        while j < n and typed[j] == ch:
            j += 1
        
        # Check if one string is exhausted but not the other
        if (i >= m and j < n) or (i < m and j >= n):
            return False
    
    return True


if __name__ == "__main__":
    name = "alex"
    typed = "aaleex"
    result = is_long_pressed_name(name, typed)
    print(result)  # Expected: True
