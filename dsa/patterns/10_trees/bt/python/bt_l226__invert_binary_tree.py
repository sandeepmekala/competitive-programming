# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/invert-binary-tree/
# Idea: Recursively invert left and right subtrees and swap left and right pointers.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def invert_tree(root):
    if not root:
        return root

    left = invert_tree(root.left)
    right = invert_tree(root.right)

    root.left = right
    root.right = left

    return root


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

invert_tree(root)

# Function to do inorder traversal to check result
def inorder_traversal(node):
    if not node:
        return []
    return inorder_traversal(node.left) + [node.val] + inorder_traversal(node.right)

print(inorder_traversal(root))  # Expected inorder of inverted tree
