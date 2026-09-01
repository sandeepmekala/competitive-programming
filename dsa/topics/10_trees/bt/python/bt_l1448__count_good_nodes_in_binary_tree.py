# Binary Tree + DFS
# Problem: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
# Idea: Track the max value along each path in recursive top-down DFS.
# Time: O(n)
# Space: O(h) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def good_nodes(root):
    def dfs(node, max_val):
        if not node:
            return 0
        count = 0
        if node.val >= max_val:
            count = 1
            max_val = node.val
        return count + dfs(node.left, max_val) + dfs(node.right, max_val)

    return dfs(root, float('-inf'))

# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(good_nodes(root))  # Expected: 4
