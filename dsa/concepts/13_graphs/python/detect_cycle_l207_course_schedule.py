"""
Problem: https://leetcode.com/problems/course-schedule/

Idea:
- Courses form a directed graph
- If there is a cycle, courses cannot be finished
- Use DFS with:
  - vis[]     -> permanently visited
  - path_vis[] -> current recursion stack

If a node is visited again while still in path_vis, a cycle exists.

Time: O(V + E)
Space: O(V + E)
"""


def can_finish(num_courses, prerequisites):
    # Build adjacency list
    adj = [[] for _ in range(num_courses)]
    for course, prereq in prerequisites:
        adj[prereq].append(course)   # prereq -> course

    vis = [0] * num_courses
    path_vis = [0] * num_courses

    for i in range(num_courses):
        if vis[i] == 0:
            if not dfs(i, adj, vis, path_vis):
                return False

    return True


"""
DFS helper to detect cycle in directed graph
"""


def dfs(node, adj, vis, path_vis):
    vis[node] = 1
    path_vis[node] = 1

    for nei in adj[node]:
        if vis[nei] == 0:
            if not dfs(nei, adj, vis, path_vis):
                return False
        elif path_vis[nei] == 1:
            # cycle detected
            return False

    path_vis[node] = 0
    return True


# -------------------- TEST --------------------
if __name__ == "__main__":
    num_courses = 3

    # prerequisites = [[1, 0]]                # True
    # prerequisites = [[1, 0], [0, 1]]        # False (cycle)
    prerequisites = [[1, 0], [2, 0]]          # True

    print(can_finish(num_courses, prerequisites))
