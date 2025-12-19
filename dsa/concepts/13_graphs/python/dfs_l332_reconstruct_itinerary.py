"""
Problem:
https://leetcode.com/problems/reconstruct-itinerary/

Idea:
- We must use all tickets exactly once (edge used once)
- Always choose lexicographically smallest destination
- Sort tickets first and build adjacency list in sorted order
- Use DFS with backtracking
- Remove an edge once used; if path fails, restore it

Time: O(E^2) worst case due to backtracking
Space: O(E)
"""


def find_itinerary(tickets):
    # Sort tickets lexicographically by source, then destination
    tickets.sort(key=lambda x: (x[0], x[1]))

    adj = {}
    for src, dst in tickets:
        adj.setdefault(src, []).append(dst)

    path = ["JFK"]
    dfs(adj, "JFK", path, len(tickets))
    return path


"""
DFS to build itinerary using all tickets exactly once
"""


def dfs(adj, src, path, total_edges):
    if len(path) == total_edges + 1:
        return True

    if src not in adj:
        return False

    for i in range(len(adj[src])):
        dst = adj[src][i]

        path.append(dst)
        adj[src].pop(i)

        if dfs(adj, dst, path, total_edges):
            return True

        # backtrack
        adj[src].insert(i, dst)
        path.pop()

    return False


# -------------------- TEST --------------------
if __name__ == "__main__":
    tickets = [
        ["MUC", "LHR"],
        ["JFK", "MUC"],
        ["SFO", "SJC"],
        ["LHR", "SFO"]
    ]

    print(find_itinerary(tickets))
