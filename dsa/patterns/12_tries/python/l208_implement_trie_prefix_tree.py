from collections import deque


class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    """
    Problem: https://leetcode.com/problems/implement-trie-prefix-tree/
    Idea: Start with root node which contains map of first chars.
    Deletion need to be handled in recursively as we need to delete the node in bottom up way.
    """

    """
    O(m) where m is max length of a word
    """
    def insert(self, word: str) -> None:
        curr = self.root
        for ch in word:
            curr.children.setdefault(ch, TrieNode())
            curr = curr.children[ch]
        curr.end_of_word = True

    def starts_with(self, prefix: str) -> bool:
        curr = self.root
        for ch in prefix:
            if ch not in curr.children:
                return False
            curr = curr.children[ch]
        return True

    """
    O(m) where m is max length of a word
    """
    def search(self, word: str) -> bool:
        curr = self.root
        for ch in word:
            if ch not in curr.children:
                return False
            curr = curr.children[ch]
        return curr.end_of_word

    def print(self) -> None:
        queue = deque([self.root])
        while queue:
            level_size = len(queue)
            for _ in range(level_size):
                node = queue.popleft()
                print(list(node.children.keys()), end=" ")
                queue.extend(node.children.values())
            print()


if __name__ == "__main__":
    trie = Trie()

    trie.insert("abc")
    trie.insert("abgl")
    trie.insert("cdf")
    trie.insert("abcd")
    trie.insert("lmn")

    trie.print()
    print(trie.starts_with("ab"))   # True
    print(trie.search("abc"))       # True
    print(trie.search("lm"))        # False
