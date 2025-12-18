"""
L819 - Most Common Word

Problem: https://leetcode.com/problems/most-common-word/
Idea: Count the freq of words
Time: O(n) where n is length of paragraph
Space: O(n) for storing word counts
"""

import re

def most_common_word(paragraph, banned):
    banned_set = set(banned)
    
    # Extract words using regex and convert to lowercase
    words = re.findall(r'\b\w+\b', paragraph.lower())
    
    # Count frequency of non-banned words
    word_count = {}
    for word in words:
        if word not in banned_set:
            word_count[word] = word_count.get(word, 0) + 1
    
    # Find word with maximum frequency
    result = ""
    max_count = 0
    for word, count in word_count.items():
        if count > max_count:
            max_count = count
            result = word
    
    return result

if __name__ == "__main__":
    paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    banned = ["hit"]
    print(f"Input: paragraph = '{paragraph}', banned = {banned}")
    print(f"Output: {most_common_word(paragraph, banned)}")
