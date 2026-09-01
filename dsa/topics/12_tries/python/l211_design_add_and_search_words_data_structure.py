class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False


class WordDictionary:
    def __init__(self):
        self.root = TrieNode()

    """
    Problem: https://leetcode.com/problems/design-add-and-search-words-data-structure/
    Search words with '.' as wildcard
    Idea: Use Trie to store words
    For search if char is '.', then loop over all chars in current map and check
    if any recursion returns true. You need to skip one char from word for '.'
    """

    def add_word(self, word: str) -> None:
        curr = self.root
        for ch in word:
            curr.children.setdefault(ch, TrieNode())
            curr = curr.children[ch]
        curr.end_of_word = True

    def search(self, word: str) -> bool:
        # when search char is '.' then we need to skip one char from word
        # hence we need to pass index as well
        return self._search(word, 0, self.root)

    def _search(self, word: str, index: int, node: TrieNode) -> bool:
        for i in range(index, len(word)):
            ch = word[i]

            if ch != '.':
                if ch not in node.children:
                    return False
                node = node.children[ch]
            else:
                # if char is '.', try all possible children
                for child in node.children.values():
                    if self._search(word, i + 1, child):  # skip one char
                        return True
                return False

        return node.end_of_word


if __name__ == "__main__":
    wd = WordDictionary()

    wd.add_word("bad")
    wd.add_word("dad")
    wd.add_word("mad")

    print(wd.search("pad"))   # False
    print(wd.search("bad"))   # True
    print(wd.search(".ad"))   # True
    print(wd.search("b.."))   # True
