# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/balanced-binary-tree/
# Idea: Check if the height is balanced for the root and recursively for left and right subtrees.
# Use -1 as sentinel for unbalanced subtree.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def is_balanced(root):
    def depth(node):
        if not node:
            return 0

        left_depth = depth(node.left)
        if left_depth == -1:
            return -1
        right_depth = depth(node.right)
        if right_depth == -1:
            return -1

        if abs(left_depth - right_depth) > 1:
            return -1

        return 1 + max(left_depth, right_depth)

    return depth(root) != -1


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(is_balanced(root))  # Expected: False
