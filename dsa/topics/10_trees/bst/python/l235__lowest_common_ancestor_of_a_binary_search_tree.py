# Tree
# Problem: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
# Idea:
# 1. If both p and q are smaller than root, LCA is in left subtree.
# 2. If both p and q are larger than root, LCA is in right subtree.
# 3. Otherwise, root is the LCA.
# Time: O(log n)
# Space: O(1)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def lowestCommonAncestor(root, p, q):
    if p.val < root.val and q.val < root.val:
        return lowestCommonAncestor(root.left, p, q)
    if p.val > root.val and q.val > root.val:
        return lowestCommonAncestor(root.right, p, q)
    return root


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

# Example: LCA of 2 and 5
p = root.left           # Node 2
q = root.left.right.right  # Node 5

lca = lowestCommonAncestor(root, p, q)
print(lca.val)  # Expected: 4
