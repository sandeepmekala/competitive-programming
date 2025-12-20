# Tree / BST
# Problem: https://leetcode.com/problems/search-in-a-binary-search-tree/
# Idea:
# 1. If val < root.val, search in left subtree.
# 2. Else search in right subtree.
# Time: O(log n) on average
# Space: O(1) (iterative) or O(log n) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def searchBST(root, val):
    if not root or root.val == val:
        return root
    if val < root.val:
        return searchBST(root.left, val)
    else:
        return searchBST(root.right, val)

def searchBSTIterative(root, val):
    curr = root
    while curr and curr.val != val:
        curr = curr.left if val < curr.val else curr.right
    return curr


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

# Recursive search
node = searchBST(root, 4)
print(node.val if node else None)  # Expected: 4

# Iterative search
node_iter = searchBSTIterative(root, 4)
print(node_iter.val if node_iter else None)  # Expected: 4
