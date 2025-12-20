class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False


"""
Problem: https://leetcode.com/problems/longest-word-with-all-prefixes/
https://leetcode.ca/2021-07-14-1858-Longest-Word-With-All-Prefixes/

Idea:
Insert all words into a Trie.
For each word, check if *all its prefixes* exist in the trie as complete words.
Choose the longest such word.
If multiple words have the same length, choose lexicographically smaller one.
"""


def longest_word(words):
    root = TrieNode()

    # Insert all words into trie
    for word in words:
        insert(root, word)

    longest = ""
    for word in words:
        if prefixes_exist(root, word):
            if len(word) > len(longest):
                longest = word
            elif len(word) == len(longest) and word < longest:
                longest = word

    return longest


def insert(root, word):
    curr = root
    for ch in word:
        if ch not in curr.children:
            curr.children[ch] = TrieNode()
        curr = curr.children[ch]
    curr.end_of_word = True


def prefixes_exist(root, word):
    curr = root
    for ch in word:
        if ch not in curr.children:
            return False
        curr = curr.children[ch]
        if not curr.end_of_word:
            return False
    return True


if __name__ == "__main__":
    words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
    print(longest_word(words))   # apple
