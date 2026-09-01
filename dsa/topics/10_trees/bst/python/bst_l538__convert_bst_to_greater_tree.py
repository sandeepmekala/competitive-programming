# Tree / Reverse Inorder Traversal
# Problem: https://leetcode.com/problems/convert-bst-to-greater-tree/
# Companies: Amazon
# Idea:
# 1. Use reverse inorder traversal: right -> root -> left.
# 2. Keep track of cumulative sum of all nodes visited so far.
# 3. Update each node's value to be its value plus sum of greater nodes.
# Time: O(n)
# Space: O(h) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def convert_bst(root):
    # sum_so_far passed as list to allow modification inside recursion
    def helper(node, sum_so_far):
        if not node:
            return sum_so_far
        # Process right subtree first
        sum_right = helper(node.right, sum_so_far)
        # Update current node
        node.val += sum_right
        # Process left subtree with updated sum
        return helper(node.left, node.val)

    helper(root, 0)
    return root


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

# Convert BST to Greater Tree
convert_bst(root)

# Inorder traversal to verify result
def inorder(node):
    return inorder(node.left) + [node.val] + inorder(node.right) if node else []

print(inorder(root))  # Expected: modified BST in inorder showing greater sums
