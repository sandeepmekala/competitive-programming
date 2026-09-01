from collections import deque
from typing import List, Set


"""
Problem: https://leetcode.com/problems/word-ladder/
Idea:
We try all possible one-character transformations for the current word.
If the transformed word exists in the given word list and is not visited,
we push it into the BFS queue with distance + 1.
Since every edge has unit weight, BFS guarantees the shortest path.
Time Complexity: O(N * L * 26)
Space Complexity: O(N)
"""
def ladder_length(start_word: str, target: str, word_list: List[str]) -> int:
    word_set: Set[str] = set(word_list)

    queue = deque()
    visited = set()

    queue.append((start_word, 1))   # (word, length)
    visited.add(start_word)

    while queue:
        word, length = queue.popleft()

        if word == target:
            return length

        for i in range(len(word)):
            for ch in range(ord('a'), ord('z') + 1):
                transformed = word[:i] + chr(ch) + word[i+1:]

                if transformed not in word_set:
                    continue

                if transformed not in visited:
                    visited.add(transformed)
                    queue.append((transformed, length + 1))

    # If no transformation sequence exists
    return 0


# one test (same as Java main)
if __name__ == "__main__":
    words = ["hot", "dot", "dog", "lot", "log", "cog"]
    print(ladder_length("hit", "cog", words))   # 5
