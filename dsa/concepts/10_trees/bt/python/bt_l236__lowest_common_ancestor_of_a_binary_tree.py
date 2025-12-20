# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
# Idea: Recursively search for p and q in left and right subtrees.
# If root matches p or q, return root.
# LCA is where left and right recursive calls both return non-null.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def lowest_common_ancestor(root, p, q):
    if not root or root.val == p.val or root.val == q.val:
        return root

    left = lowest_common_ancestor(root.left, p, q)
    right = lowest_common_ancestor(root.right, p, q)

    if not left:
        return right
    if not right:
        return left

    return root


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

lca = lowest_common_ancestor(root, root.left.left, root.left.right.left)
print(lca.val if lca else None)  # Expected: 3
