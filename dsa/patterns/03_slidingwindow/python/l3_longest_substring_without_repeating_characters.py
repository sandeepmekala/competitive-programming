"""
L3 - Longest Substring Without Repeating Characters

Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
Idea: Use 2 pointers. You can store the index i+1 with each repeating char in map so that, j can be jumped to that.
Time: O(n)
Space: O(min(m,n)) where m is the size of the charset
"""

def length_of_longest_substring(s):
    char_index = [0] * 256  # ASCII character set
    
    l, r, max_len, n = 0, 0, 0, len(s)
    
    while r < n:
        ch = s[r]
        # Update l pointer until the char is not in set
        if char_index[ord(ch)] != 0:
            l = max(l, char_index[ord(ch)])  # abba case
        
        char_index[ord(ch)] = r + 1  # store the index to which l should jump
        
        max_len = max(max_len, r - l + 1)
        r += 1
    
    return max_len


if __name__ == "__main__":
    test_input = "aabcbe"
    print(f"Input: s = '{test_input}'")
    print(f"Output: {length_of_longest_substring(test_input)}")
    
    # Additional test cases
    test_cases = ["abcabcbb", "bbbbb", "pwwkew", ""]
    for test in test_cases:
        print(f"Input: s = '{test}' -> Output: {length_of_longest_substring(test)}")
