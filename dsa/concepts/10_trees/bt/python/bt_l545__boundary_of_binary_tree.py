# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/boundary-of-binary-tree/
# Idea: 
# 1. Traverse left boundary (excluding leaves)
# 2. Traverse all leaves (inorder)
# 3. Traverse right boundary (excluding leaves) in reverse
# Time: O(n)
# Space: O(1) ignoring recursion stack

def boundary_of_binary_tree(root):
    if not root:
        return []

    boundary = []
    if not is_leaf(root):
        boundary.append(root.val)

    add_left_boundary(root, boundary)
    add_leaves(root, boundary)
    add_right_boundary(root, boundary)

    return boundary

def add_left_boundary(root, boundary):
    curr = root.left
    while curr:
        if not is_leaf(curr):
            boundary.append(curr.val)
        if curr.left:
            curr = curr.left
        else:
            curr = curr.right

def add_right_boundary(root, boundary):
    curr = root.right
    stack = []
    while curr:
        if not is_leaf(curr):
            stack.append(curr.val)
        if curr.right:
            curr = curr.right
        else:
            curr = curr.left
    while stack:
        boundary.append(stack.pop())  # add in reverse

def add_leaves(root, boundary):
    if is_leaf(root):
        boundary.append(root.val)
        return
    if root.left:
        add_leaves(root.left, boundary)
    if root.right:
        add_leaves(root.right, boundary)

def is_leaf(node):
    return not node.left and not node.right


# -------- Test --------
root = TreeNode(1)
root.right = TreeNode(2)
root.right.left = TreeNode(3)
root.right.right = TreeNode(4)

print(boundary_of_binary_tree(root))  # Expected: [1, 3, 4, 2]
