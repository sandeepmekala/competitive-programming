"""
L76 - Minimum Window Substring

Problem: https://leetcode.com/problems/minimum-window-substring/
Idea: Use map to keep track of frequency of characters in t.
Insert chars of s also in map and decrease the counts.
Use cnt to keep track of number of characters in t that are present in the current window.
While insert s chars, if char is already positive, means it is inserted by t. So, increase cnt.
One cnt reach m, start shrinking the window from left and decrease cnt if any char in t goes out of window(mean freq become +ve).
Time: O(n)
Space: O(1) - constant space for ASCII characters
"""

def min_window(s, t):
    m, n = len(t), len(s)
    l, r, min_len, start, cnt = 0, 0, float('inf'), -1, 0
    char_map = [0] * 256  # ASCII character frequency map
    
    # Count frequency of characters in t
    for ch in t:
        char_map[ord(ch)] += 1
    
    while r < n:
        # If character is needed (positive count), increment cnt
        if char_map[ord(s[r])] > 0:
            cnt += 1
        char_map[ord(s[r])] -= 1
        
        # When we have all characters from t in current window
        while cnt == m:
            # Update minimum window if current is smaller
            if r - l + 1 < min_len:
                min_len = r - l + 1
                start = l
            
            # Try to shrink window from left
            char_map[ord(s[l])] += 1
            if char_map[ord(s[l])] > 0:
                cnt -= 1
            l += 1
        
        r += 1
    
    return "" if start == -1 else s[start:start + min_len]


if __name__ == "__main__":
    s = "ADOBECODEBANC"
    t = "ABC"
    print(f"Input: s = '{s}', t = '{t}'")
    print(f"Output: '{min_window(s, t)}'")
    
    # Additional test cases
    test_cases = [
        ("a", "a"),
        ("a", "aa"),
        ("ab", "b"),
        ("ADOBECODEBANC", "AABC")
    ]
    
    for s_test, t_test in test_cases:
        result = min_window(s_test, t_test)
        print(f"Input: s = '{s_test}', t = '{t_test}' -> Output: '{result}'")
