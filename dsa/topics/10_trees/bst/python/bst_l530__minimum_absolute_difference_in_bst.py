# Tree / Inorder Traversal
# Problem: https://leetcode.com/problems/minimum-absolute-difference-in-bst/
# Idea:
# 1. Inorder traversal of BST gives nodes in sorted order.
# 2. Track previous node value and compute difference with current node.
# 3. Minimum difference is the smallest difference between consecutive nodes.
# Time: O(n)
# Space: O(h) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def get_minimum_difference(root):
    prev = [float('inf')]  # previous node value
    min_diff = [float('inf')]  # minimum difference

    def inorder(node):
        if not node:
            return
        inorder(node.left)
        # Compute difference with previous node
        if prev[0] != float('inf'):
            min_diff[0] = min(min_diff[0], abs(node.val - prev[0]))
        prev[0] = node.val
        inorder(node.right)

    inorder(root)
    return min_diff[0]


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

print(get_minimum_difference(root))  # Expected: 1
