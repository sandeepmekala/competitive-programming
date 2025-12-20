# Tree / BST
# Problem: https://leetcode.com/problems/insert-into-a-binary-search-tree/
# Idea:
# 1. Find the correct position for the new value using BST property.
# 2. Insert as a new node.
# Time: O(log n) on average
# Space: O(1) iterative, O(log n) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def insertIntoBST(root, val):
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insertIntoBST(root.left, val)
    else:
        root.right = insertIntoBST(root.right, val)
    return root

def insertIntoBSTIterative(root, val):
    if not root:
        return TreeNode(val)
    
    curr = root
    while True:
        if val > curr.val:
            if curr.right:
                curr = curr.right
            else:
                curr.right = TreeNode(val)
                break
        else:
            if curr.left:
                curr = curr.left
            else:
                curr.left = TreeNode(val)
                break
    return root


# -------- Test --------
root = None
for val in [10, 2, 4, 6, 5, 15, 3]:
    root = insertIntoBST(root, val)

# Helper function to print inorder traversal
def inorder_print(node):
    if not node:
        return
    inorder_print(node.left)
    print(node.val, end=' ')
    inorder_print(node.right)

inorder_print(root)  # Expected inorder: 2 3 4 5 6 10 15
