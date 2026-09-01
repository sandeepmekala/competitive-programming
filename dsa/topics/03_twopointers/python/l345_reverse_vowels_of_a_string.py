"""
L345 - Reverse Vowels of a String
Problem: https://leetcode.com/problems/reverse-vowels-of-a-string/
Companies: Google, Amazon
Idea: One pointer comes from back and one from front.
Time: O(n)
Space: O(n) for converting string to list
"""

def reverse_vowels(s):
    """
    Reverse only the vowels in a string.
    
    Args:
        s: str - Input string
    
    Returns:
        str - String with vowels reversed
    """
    def is_vowel(ch):
        return ch in 'aeiouAEIOU'
    
    chars = list(s)
    n = len(chars)
    i, j = 0, n - 1
    
    while i < j:
        while i < n and not is_vowel(chars[i]):
            i += 1
        while j >= 0 and not is_vowel(chars[j]):
            j -= 1
        
        if i < j:
            chars[i], chars[j] = chars[j], chars[i]
            i += 1
            j -= 1
    
    return ''.join(chars)


if __name__ == "__main__":
    s = "hello"
    result = reverse_vowels(s)
    print(result)  # Expected: "holle"
