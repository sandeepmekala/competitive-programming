class TrieNode:
    def __init__(self):
        self.children = {}
        self.end_of_word = False


"""
Problem: https://leetcode.com/problems/word-search-ii/
Idea:
Build a trie of all the words.
Do DFS on the grid and track the word being formed.
Move in the grid only if the next character exists in the trie.
If the trie node is endOfWord, add the word to result.
"""


def find_words(board, words):
    root = TrieNode()
    for word in words:
        _insert(root, word)

    m, n = len(board), len(board[0])
    visited = [[False] * n for _ in range(m)]
    result = set()

    for i in range(m):
        for j in range(n):
            if board[i][j] in root.children:
                _dfs(board, root, i, j, "", visited, result)

    return list(result)


def _dfs(board, node, i, j, word, visited, result):
    node = node.children[board[i][j]]
    word += board[i][j]

    if node.end_of_word:
        result.add(word)

    visited[i][j] = True

    for dx, dy in ((1, 0), (-1, 0), (0, 1), (0, -1)):
        ni, nj = i + dx, j + dy
        if _is_safe(board, node, ni, nj, visited):
            _dfs(board, node, ni, nj, word, visited, result)

    # backtrack
    visited[i][j] = False


def _insert(root, word):
    curr = root
    for ch in word:
        curr.children.setdefault(ch, TrieNode())
        curr = curr.children[ch]
    curr.end_of_word = True


def _is_safe(board, node, i, j, visited):
    return (
        0 <= i < len(board)
        and 0 <= j < len(board[0])
        and not visited[i][j]
        and board[i][j] in node.children
    )


if __name__ == "__main__":
    board = [
        ['o', 'a', 'a', 'n'],
        ['e', 't', 'a', 'e'],
        ['i', 'h', 'k', 'r'],
        ['i', 'f', 'l', 'v']
    ]

    words = ["oath", "pea", "eat", "rain"]

    print(find_words(board, words))
