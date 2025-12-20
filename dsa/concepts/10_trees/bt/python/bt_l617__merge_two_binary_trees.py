# Binary Tree
# Problem: https://leetcode.com/problems/merge-two-binary-trees/
# Idea: Traverse both trees at the same time. Sum nodes if both exist.
# Time: O(n)
# Space: O(1) (ignoring recursion stack)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def merge_trees(root1, root2):
    if not root1 and not root2:
        return None
    elif not root1:
        return root2
    elif not root2:
        return root1
    else:
        root1.val += root2.val
        root1.left = merge_trees(root1.left, root2.left)
        root1.right = merge_trees(root1.right, root2.right)
        return root1

# Helper function to insert into BST
def insert_into_bst(root, val):
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insert_into_bst(root.left, val)
    else:
        root.right = insert_into_bst(root.right, val)
    return root

# Helper function to do inorder traversal (for testing)
def inorder(root):
    if root:
        inorder(root.left)
        print(root.val, end=' ')
        inorder(root.right)

# -------- Test --------
root1 = None
for val in [10, 2, 4, 6, 5, 15, 3]:
    root1 = insert_into_bst(root1, val)

root2 = None
for val in [10, 2, 4, 6, 5, 15, 3]:
    root2 = insert_into_bst(root2, val)

merged_root = merge_trees(root1, root2)
inorder(merged_root)  # Expected output: merged inorder values
