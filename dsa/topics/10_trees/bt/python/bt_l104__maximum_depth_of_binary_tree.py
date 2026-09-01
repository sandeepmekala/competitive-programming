# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/maximum-depth-of-binary-tree/
# Idea: Maximum depth is the number of nodes along the longest path to any leaf node.
# 1 + max(left_depth, right_depth)
# Time: O(n)
# Space: O(1) ignoring recursion stack

def max_depth(root):
    if not root:
        return 0

    left_depth = max_depth(root.left)
    right_depth = max_depth(root.right)
    return 1 + max(left_depth, right_depth)


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(max_depth(root))  # Expected: 4
