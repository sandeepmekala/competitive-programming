# Binary Tree + BFS
# Problem: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
# Idea:
# 1. Track horizontal column index for each node.
# 2. For each column, store the first node encountered in BFS.
# 3. Return values in order of sorted columns.
# Time: O(n)
# Space: O(n)

from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class TopViewTuple:
    def __init__(self, node, col):
        self.node = node
        self.col = col

def top_view(root):
    if not root:
        return []

    column_map = {}
    q = deque([TopViewTuple(root, 0)])

    while q:
        curr = q.popleft()
        node, col = curr.node, curr.col
        if col not in column_map:
            column_map[col] = node.val  # Store first node at this column

        if node.left:
            q.append(TopViewTuple(node.left, col - 1))
        if node.right:
            q.append(TopViewTuple(node.right, col + 1))

    return [column_map[col] for col in sorted(column_map.keys())]

# -------- Test --------
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

print(top_view(root))  # Expected: [9, 3, 20, 7]
