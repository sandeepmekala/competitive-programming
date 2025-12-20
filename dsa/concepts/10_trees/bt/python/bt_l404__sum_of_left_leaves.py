# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/sum-of-left-leaves/
# Idea: Use a flag to differentiate left and right child nodes.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def sum_of_left_leaves(root):
    def helper(node, is_left):
        if not node:
            return 0
        if not node.left and not node.right:  # leaf node
            return node.val if is_left else 0
        return helper(node.left, True) + helper(node.right, False)

    return helper(root, False)


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(sum_of_left_leaves(root))  # Expected: 7 (2 + 5)
