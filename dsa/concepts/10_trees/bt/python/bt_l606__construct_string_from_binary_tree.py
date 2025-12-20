# Binary Tree
# Problem: https://leetcode.com/problems/construct-string-from-binary-tree/
# Idea:
# 1. If left child is not there and right child is there, we need to keep () for left child.
# 2. If right child is not there, we don't need ().
# 3. Use recursion with a flag to denote if it's a left child call.
# Time: O(n)
# Space: O(h) for recursion stack, h = height of tree

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def tree2str(root, is_left=False):
    if root is None and is_left:
        return ""
    if root is None and not is_left:
        return None
    if root.left is None and root.right is None:
        return str(root.val)

    left = tree2str(root.left, True)
    right = tree2str(root.right, False)

    result = str(root.val) + "(" + left + ")"
    if right is not None:
        result += "(" + right + ")"
    return result

# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(tree2str(root))  # Expected: "1(3(2)(6(5)))(4)"
