# Tree
# Problem: https://leetcode.com/problems/inorder-successor-in-bst/
# https://www.lintcode.com/problem/448/
# Idea:
# 1. Similar to finding ceil in a BST.
# 2. Track successor and continuously update it when a better candidate is found.
# Time: O(log n)
# Space: O(1)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def inorderSuccessor(root, p):
    curr = root
    succ = None
    while curr:
        if curr.val > p.val:
            succ = curr
            curr = curr.left
        else:
            curr = curr.right
    return succ


# -------- Test --------
# Helper function to insert into BST
def insertIntoBST(root, val):
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insertIntoBST(root.left, val)
    else:
        root.right = insertIntoBST(root.right, val)
    return root

root = None
for val in [10, 2, 4, 6, 5, 15, 3]:
    root = insertIntoBST(root, val)

# Example: Inorder successor of 5
p = TreeNode(5)
succ = inorderSuccessor(root, p)
print(succ.val if succ else None)  # Expected: 6
