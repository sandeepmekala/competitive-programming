class TrieNode:
    def __init__(self):
        self.children = {}
        self.count_prefix = 0
        self.count_end = 0


class Trie:
    def __init__(self):
        self.root = TrieNode()

    """
    Problem: https://leetcode.ca/2020-11-07-1804-Implement-Trie-II-(Prefix-Tree)/
    Idea:
    Maintain two counters at each node:
    - count_prefix → how many words pass through this node
    - count_end → how many words end at this node
    """

    def insert(self, word: str) -> None:
        curr = self.root
        for ch in word:
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
            curr = curr.children[ch]
            curr.count_prefix += 1
        curr.count_end += 1

    def countWordsEqualTo(self, word: str) -> int:
        curr = self.root
        for ch in word:
            if ch not in curr.children:
                return 0
            curr = curr.children[ch]
        return curr.count_end

    def countWordsStartingWith(self, prefix: str) -> int:
        curr = self.root
        for ch in prefix:
            if ch not in curr.children:
                return 0
            curr = curr.children[ch]
        return curr.count_prefix

    def erase(self, word: str) -> None:
        curr = self.root
        for ch in word:
            curr = curr.children[ch]
            curr.count_prefix -= 1
        curr.count_end -= 1


if __name__ == "__main__":
    trie = Trie()

    trie.insert("apple")
    trie.insert("apple")

    print(trie.countWordsEqualTo("apple"))      # 2
    print(trie.countWordsStartingWith("app"))   # 2

    trie.erase("apple")
    print(trie.countWordsEqualTo("apple"))      # 1
    print(trie.countWordsStartingWith("app"))   # 1

    trie.erase("apple")
    print(trie.countWordsEqualTo("apple"))      # 0
