class TrieNode:
    def __init__(self):
        self.children = {}


"""
Problem: https://leetcode.ca/2020-07-24-1698-Number-of-Distinct-Substrings-in-a-String/
Idea:
For each character in a string, create all possible substrings and insert them in Trie.
"abc" -> "a", "ab", "abc", "b", "bc", "c"
For every new character, new substrings will be created.
If some prefix is already inserted by some other substring, then chars will be already present in trie.
"""


def count_distinct(s: str) -> int:
    root = TrieNode()
    count = 0

    for i in range(len(s)):
        curr = root
        for j in range(i, len(s)):
            ch = s[j]               # substring from i to j
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
                count += 1          # new character → new substring
            curr = curr.children[ch]

    return count


if __name__ == "__main__":
    s = "aabbaba"
    print(count_distinct(s))
