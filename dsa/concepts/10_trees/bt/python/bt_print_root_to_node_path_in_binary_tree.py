# Binary Tree + DFS
# Problem: https://www.interviewbit.com/problems/path-to-given-node/
# Idea:
# 1. Use DFS to traverse the tree.
# 2. Track path by adding node values on recursion entry.
# 3. Remove node values if path does not lead to target.
# Time: O(n)
# Space: O(h) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def path(root, data):
    result = []

    def dfs(node):
        if not node:
            return False
        result.append(node.val)
        if node.val == data:
            return True
        if dfs(node.left) or dfs(node.right):
            return True
        result.pop()
        return False

    return result if dfs(root) else None

# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(path(root, 5))  # Expected: [1, 3, 6, 5]
