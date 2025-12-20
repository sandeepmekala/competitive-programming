# Binary Tree + BFS
# Problem: https://www.geeksforgeeks.org/minimum-time-to-burn-a-tree-starting-from-a-leaf-node/
# Idea:
# 1. Map each node to its parent.
# 2. BFS from target node, visiting left, right, and parent nodes.
# 3. Count levels while spreading fire until all nodes are burnt.
# Time: O(n)
# Space: O(n)

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def burn(root, target):
    # Step 1: mark parents
    parents = {}
    mark_parent(root, parents)
    
    visited = set()
    q = deque([target])
    visited.add(target)
    level = 0

    while q:
        burnt = False
        for _ in range(len(q)):
            node = q.popleft()
            for neighbor in (node.left, node.right, parents.get(node)):
                if neighbor and neighbor not in visited:
                    visited.add(neighbor)
                    q.append(neighbor)
                    burnt = True
        if burnt:
            level += 1

    return level

def mark_parent(root, parent_map):
    q = deque([root])
    while q:
        node = q.popleft()
        if node.left:
            parent_map[node.left] = node
            q.append(node.left)
        if node.right:
            parent_map[node.right] = node
            q.append(node.right)

# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)

print(burn(root, root.left))  # Expected: 3
