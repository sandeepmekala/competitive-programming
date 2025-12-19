from typing import List, Dict


"""
Problem:
https://www.lintcode.com/problem/892
https://leetcode.com/problems/alien-dictionary/

Idea:
Words are already sorted lexicographically according to an unknown alien language.

Approach:
1. Build a graph of character precedence from adjacent words
2. For each adjacent word pair, find the first differing character
   and add an edge: char1 -> char2
3. Perform DFS-based topological sort on characters
4. Use pathVis to detect cycles (invalid ordering)
5. Reverse postorder gives alien dictionary order

Time Complexity: O(C + E)
Space Complexity: O(C + E)
Where C = number of unique characters
"""
def alien_order(words: List[str]) -> str:
    adj: Dict[str, List[str]] = {}

    # Initialize graph with all unique characters
    for word in words:
        for ch in word:
            if ch not in adj:
                adj[ch] = []

    # Build precedence graph from adjacent words
    for i in range(len(words) - 1):
        w1, w2 = words[i], words[i + 1]
        min_len = min(len(w1), len(w2))

        for j in range(min_len):
            if w1[j] != w2[j]:
                adj[w1[j]].append(w2[j])
                break

    vis = set()
    path_vis = set()
    stack = []

    for ch in adj:
        if ch not in vis:
            if not dfs(adj, ch, vis, path_vis, stack):
                return ""

    return "".join(reversed(stack))


"""
DFS helper for topological sorting with cycle detection

Returns False if a cycle is detected
"""
def dfs(adj: Dict[str, List[str]], ch: str,
        vis: set, path_vis: set, stack: List[str]) -> bool:
    vis.add(ch)
    path_vis.add(ch)

    for nei in adj[ch]:
        if nei not in vis:
            if not dfs(adj, nei, vis, path_vis, stack):
                return False
        elif nei in path_vis:
            return False

    path_vis.remove(ch)
    stack.append(ch)
    return True


# one test (same as Java main)
if __name__ == "__main__":
    words = ["wrt", "wrf", "er", "ett", "rftt"]
    print(alien_order(words))
