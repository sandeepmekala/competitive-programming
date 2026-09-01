# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/subtree-of-another-tree
# Idea: For each node in root, check if it's the same as subRoot.
# If not, recursively check left and right subtrees.
# Time: O(n * m) in worst case, where n = size of root, m = size of subRoot
# Space: O(1) ignoring recursion stack

def is_subtree(root, sub_root):
    if not root:
        return False

    if is_same_tree(root, sub_root):
        return True

    return is_subtree(root.left, sub_root) or is_subtree(root.right, sub_root)

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

print(is_subtree(root, root))  # Expected: True
