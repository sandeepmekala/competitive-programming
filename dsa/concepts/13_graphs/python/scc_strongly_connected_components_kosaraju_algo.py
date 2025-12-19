from collections import defaultdict
from typing import List, Set


def get_strongly_connected_components(adj: List[List[int]]) -> List[Set[int]]:
    """
    Idea: Kosaraju’s Algorithm

    Steps:
    1. Do DFS and push nodes into a stack based on finishing time
       (reverse topological order).
    2. Reverse all edges of the graph.
    3. Pop nodes from stack and do DFS on the reversed graph.
       Each DFS traversal gives one Strongly Connected Component (SCC).

    Time Complexity: O(V + E)
    Space Complexity: O(V + E)
    """
    n = len(adj)
    visited = [False] * n
    stack = []

    # Step 1: DFS to fill stack by finish time
    def dfs(node: int):
        visited[node] = True
        for nei in adj[node]:
            if not visited[nei]:
                dfs(nei)
        stack.append(node)

    for i in range(n):
        if not visited[i]:
            dfs(i)

    # Step 2: Reverse the graph
    rev_adj = [[] for _ in range(n)]
    for u in range(n):
        for v in adj[u]:
            rev_adj[v].append(u)

    # Step 3: DFS on reversed graph using stack order
    visited = [False] * n
    components: List[Set[int]] = []

    def dfs_rev(node: int, component: Set[int]):
        visited[node] = True
        component.add(node)
        for nei in rev_adj[node]:
            if not visited[nei]:
                dfs_rev(nei, component)

    while stack:
        node = stack.pop()
        if not visited[node]:
            component = set()
            dfs_rev(node, component)
            components.append(component)

    return components


if __name__ == "__main__":
    adj = [[] for _ in range(11)]
    adj[0].append(1)
    adj[1].append(2)
    adj[2].append(0)
    adj[1].append(3)
    adj[3].append(4)
    adj[4].append(5)
    adj[5].append(3)
    adj[6].append(5)
    adj[6].append(7)
    adj[7].append(8)
    adj[8].append(9)
    adj[9].append(6)
    adj[9].append(10)

    sccs = get_strongly_connected_components(adj)
    print(sccs)
