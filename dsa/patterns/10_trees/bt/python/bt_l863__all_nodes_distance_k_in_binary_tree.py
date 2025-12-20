# Binary Tree + BFS
# Problem: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
# Idea:
# 1. Map each node to its parent to traverse back up.
# 2. Perform BFS from target, exploring left, right, and parent nodes.
# 3. Stop when level == k, collect all node values in the queue.
# Time: O(n)
# Space: O(n) for parent map and visited set

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def distanceK(root, target, k):
    parent = {}
    mark_parent(root, parent)
    
    visited = set()
    q = deque([target])
    visited.add(target)
    
    level = 0
    while q:
        if level == k:
            break
        size = len(q)
        for _ in range(size):
            node = q.popleft()
            for neighbor in (node.left, node.right, parent.get(node)):
                if neighbor and neighbor not in visited:
                    visited.add(neighbor)
                    q.append(neighbor)
        level += 1
    
    return [node.val for node in q]

def mark_parent(root, parent):
    q = deque([root])
    while q:
        node = q.popleft()
        if node.left:
            parent[node.left] = node
            q.append(node.left)
        if node.right:
            parent[node.right] = node
            q.append(node.right)

# -------- Test --------
root = TreeNode(3)
root.left = TreeNode(5)
root.right = TreeNode(1)
root.left.left = TreeNode(6)
root.left.right = TreeNode(2)
root.right.left = TreeNode(0)
root.right.right = TreeNode(8)
root.left.right.left = TreeNode(7)
root.left.right.right = TreeNode(4)

print(distanceK(root, root.left, 2))  # Expected: [7, 4, 1]
