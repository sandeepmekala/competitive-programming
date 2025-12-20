# Binary Tree + BFS
# Problem: Bottom View of Binary Tree
# Idea:
# 1. Track horizontal column index for each node.
# 2. For each column, keep the latest (bottom-most) node value encountered in BFS.
# 3. Return values in order of sorted columns.
# Time: O(n)
# Space: O(n)

from collections import deque, OrderedDict

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Tuple2:
    def __init__(self, node, col):
        self.node = node
        self.col = col

def bottom_view(root):
    if not root:
        return []

    column_map = {}
    q = deque([Tuple2(root, 0)])

    while q:
        curr = q.popleft()
        node, col = curr.node, curr.col
        # Overwrite value for the column; last value in BFS at this column will be bottom view
        column_map[col] = node.val

        if node.left:
            q.append(Tuple2(node.left, col - 1))
        if node.right:
            q.append(Tuple2(node.right, col + 1))

    return [column_map[col] for col in sorted(column_map.keys())]

# -------- Test --------
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

print(bottom_view(root))  # Expected: [9, 3, 15, 20, 7]
