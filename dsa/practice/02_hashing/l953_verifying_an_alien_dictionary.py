"""
L953 - Verifying an Alien Dictionary

Problem: https://leetcode.com/problems/verifying-an-alien-dictionary/
Idea: Store lexicography order of letters in map with index as value
Time: O(n*m) where n is number of words, m is average word length
Space: O(1) - fixed size alphabet map
"""

def is_alien_sorted(words, order):
    # Create mapping of character to its order position
    char_order = {}
    for i, char in enumerate(order):
        char_order[char] = i
    
    # Compare adjacent words
    for i in range(1, len(words)):
        prev_word = words[i-1]
        curr_word = words[i]
        
        # Skip if words are identical
        if prev_word == curr_word:
            continue
            
        # If current word starts with previous word, it's valid
        if curr_word.startswith(prev_word):
            continue
            
        # If previous word starts with current word, it's invalid
        if prev_word.startswith(curr_word):
            return False
        
        # Find first differing character
        j = 0
        while j < len(prev_word) and j < len(curr_word) and prev_word[j] == curr_word[j]:
            j += 1
        
        # If we found differing characters, check their order
        if j < len(prev_word) and j < len(curr_word):
            if char_order[prev_word[j]] > char_order[curr_word[j]]:
                return False
    
    return True

if __name__ == "__main__":
    words = ["hello", "leetcode"]
    order = "hlabcdefgijkmnopqrstuvwxyz"
    print(f"Input: words = {words}, order = '{order}'")
    print(f"Output: {is_alien_sorted(words, order)}")
