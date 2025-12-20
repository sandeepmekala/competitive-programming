# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/diameter-of-binary-tree/
# Idea: At each node, compute max depth of left and right.
# Diameter at a node = left_depth + right_depth
# Use a global variable to track max diameter.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def diameter_of_binary_tree(root):
    diameter = 0

    def depth(node):
        nonlocal diameter
        if not node:
            return 0
        left_depth = depth(node.left)
        right_depth = depth(node.right)

        diameter = max(diameter, left_depth + right_depth)
        return 1 + max(left_depth, right_depth)

    depth(root)
    return diameter


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(diameter_of_binary_tree(root))  # Expected: 5 (edges in longest path)
