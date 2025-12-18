"""
L290 - Word Pattern

Problem: https://leetcode.com/problems/word-pattern/
Idea: Maintain a mapping between char to word and vice versa
Time: O(n)
Space: O(n)
"""

def word_pattern(pattern, s):
    char_to_word = {}
    word_to_char = {}
    
    words = s.split()
    
    if len(pattern) != len(words):
        return False
    
    for char, word in zip(pattern, words):
        # Check if char already mapped to a different word
        if char in char_to_word and char_to_word[char] != word:
            return False
        
        # Check if word already mapped to a different char
        if word in word_to_char and word_to_char[word] != char:
            return False
        
        # Create the mappings
        char_to_word[char] = word
        word_to_char[word] = char
    
    return True


if __name__ == "__main__":
    test_cases = [
        ("abba", "dog cat cat dog"),
        ("abba", "dog cat cat fish"),
        ("aaaa", "dog cat cat dog"),
        ("abba", "dog dog dog dog")
    ]
    
    for i, (pattern, s) in enumerate(test_cases, 1):
        print(f"Test case {i}: pattern = '{pattern}', s = '{s}'")
        print(f"Word pattern match: {word_pattern(pattern, s)}")
        print()
