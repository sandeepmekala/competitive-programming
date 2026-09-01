from typing import List


"""
Problem:
https://leetcode.com/problems/course-schedule-ii/

Idea:
We need to find any valid topological ordering of courses.

Approach:
1. Build adjacency list where prerequisite -> course
2. Use DFS-based topological sort
3. Use two arrays:
   - vis     : marks visited nodes
   - pathVis : marks nodes in current DFS path (for cycle detection)
4. If a cycle is detected, return empty list
5. Push nodes to stack after DFS completes (postorder)
6. Reverse stack order to get result

Time Complexity: O(V + E)
Space Complexity: O(V + E)
"""
def find_order(n: int, prerequisites: List[List[int]]) -> List[int]:
    adj = [[] for _ in range(n)]
    for crs, prer in prerequisites:
        adj[prer].append(crs)

    vis = [0] * n
    path_vis = [0] * n
    stack = []

    for i in range(n):
        if vis[i] == 0:
            if not dfs(adj, i, vis, path_vis, stack):
                return []

    stack.reverse()
    return stack


"""
DFS helper for topological sort with cycle detection

Returns False if a cycle is detected
"""
def dfs(adj, node, vis, path_vis, stack):
    vis[node] = 1
    path_vis[node] = 1

    for neigh in adj[node]:
        if vis[neigh] == 0:
            if not dfs(adj, neigh, vis, path_vis, stack):
                return False
        elif path_vis[neigh] == 1:
            return False

    path_vis[node] = 0
    stack.append(node)
    return True


# one test (same as Java main)
if __name__ == "__main__":
    num_courses = 4
    prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]

    result = find_order(num_courses, prerequisites)
    print(result)
