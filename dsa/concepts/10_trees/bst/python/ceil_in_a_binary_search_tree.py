# BST / Iterative
# Idea:
# 1. When root.val >= key, root.val is a candidate for ceil.
# 2. Try to minimize ceil by moving to left subtree.
# 3. If root.val < key, move to right subtree.
# Time: O(log n) on balanced BST
# Space: O(1)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def find_ceil(root, key):
    ceil = -1
    curr = root
    while curr:
        if curr.val >= key:
            ceil = curr.val
            curr = curr.left
        else:
            curr = curr.right
    return ceil


# -------- Test --------
# Helper to insert into BST
def insert_into_bst(root, val):
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insert_into_bst(root.left, val)
    else:
        root.right = insert_into_bst(root.right, val)
    return root

# Construct BST
root = None
for val in [10, 2, 4, 7, 5, 15, 3]:
    root = insert_into_bst(root, val)

print(find_ceil(root, 6))  # Expected: 7
