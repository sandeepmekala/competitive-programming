# Tree / BST
# Problem: https://leetcode.com/problems/range-sum-of-bst/
# Idea:
# 1. Use BST properties to skip subtrees that are out of range.
# 2. If root.val > high, only search left subtree.
# 3. If root.val < low, only search right subtree.
# 4. Otherwise, add root.val and recurse both sides.
# Time: O(n) in worst case
# Space: O(h) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def range_sum_bst(root, low, high):
    if not root:
        return 0

    if root.val > high:
        return range_sum_bst(root.left, low, high)
    elif root.val < low:
        return range_sum_bst(root.right, low, high)
    else:
        return (
            root.val
            + range_sum_bst(root.left, low, root.val)
            + range_sum_bst(root.right, root.val, high)
        )


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
for val in [10, 2, 4, 6, 5, 15, 3]:
    root = insert_into_bst(root, val)

print(range_sum_bst(root, 2, 5))  # Expected: sum of nodes with values in [2,5]
