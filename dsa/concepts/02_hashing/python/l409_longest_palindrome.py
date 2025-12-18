"""
L409 - Longest Palindrome

Problem: https://leetcode.com/problems/longest-palindrome/
Idea: Count all chars with even num of occurrence
Time: O(n)
Space: O(1)
"""

def longest_palindrome(s):
    char_set = set()
    count = 0
    
    for char in s:
        if char in char_set:
            char_set.remove(char)
            count += 1
        else:
            char_set.add(char)
    
    # If set is empty, all chars have even count
    # If set has chars, we can add one odd char in middle
    return 2 * count + (1 if char_set else 0)


if __name__ == "__main__":
    s = "abccccdd"
    print(f"Input: '{s}'")
    print(f"Longest palindrome length: {longest_palindrome(s)}")
