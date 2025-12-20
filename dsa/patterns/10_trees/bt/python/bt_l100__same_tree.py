# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/same-tree/
# Idea: Root values should be same and left and right subtrees should also be same.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def is_same_tree(root1, root2):
    if not root1 or not root2:
        return root1 is root2

    return (root1.val == root2.val and 
            is_same_tree(root1.left, root2.left) and 
            is_same_tree(root1.right, root2.right))


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(is_same_tree(root, root))  # Expected: True
