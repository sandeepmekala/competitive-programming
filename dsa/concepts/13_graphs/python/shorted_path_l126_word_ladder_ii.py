from collections import deque
from typing import List, Set


"""
Problem: https://leetcode.com/problems/word-ladder-ii/
Idea: Apply BFS and keep track of all the paths in queue.
We need to mark a word as visited only once a level is complete,
as the same word might be needed in multiple paths.
"""
def find_ladders(begin_word: str, end_word: str, word_list: List[str]) -> List[List[str]]:
    word_set: Set[str] = set(word_list)
    if end_word not in word_set:
        return []

    q = deque()
    q.append([begin_word])

    visited = set([begin_word])
    ans = []

    while q:
        size = len(q)
        level_visited = set()

        for _ in range(size):
            path = q.popleft()
            word = path[-1]

            if word == end_word:
                ans.append(path)
                continue

            for i in range(len(word)):
                for ch in "abcdefghijklmnopqrstuvwxyz":
                    if ch == word[i]:
                        continue
                    new_word = word[:i] + ch + word[i + 1:]

                    if new_word in word_set and new_word not in visited:
                        q.append(path + [new_word])
                        level_visited.add(new_word)

        visited.update(level_visited)

        if ans:
            return ans

    return []


# one test (same as Java main)
if __name__ == "__main__":
    start_word = "der"
    target_word = "dfs"
    word_list = ["des", "der", "dfr", "dgt", "dfs"]

    print(find_ladders(start_word, target_word, word_list))
