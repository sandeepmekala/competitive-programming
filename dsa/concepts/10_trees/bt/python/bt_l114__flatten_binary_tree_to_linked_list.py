# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
# Idea: Traverse in reverse postorder and flatten
# Use a global prev variable to track last explored node. Assign it to right of current node.
# Update current as next previous for next iteration.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def flatten(root):
    prev = None

    def helper(node):
        nonlocal prev
        if not node:
            return

        helper(node.right)
        helper(node.left)

        node.right = prev
        node.left = None
        prev = node

    helper(root)


# Idea: Use Morris-style traversal iteratively
# For each node with a left child, find rightmost node in left subtree
# Assign rightmost.right = current.right, then move left subtree to right
# Time: O(n)
# Space: O(1)
def flatten_iterative(root):
    curr = root
    while curr:
        if curr.left:
            prev = curr.left
            while prev.right:
                prev = prev.right
            prev.right = curr.right
            curr.right = curr.left
            curr.left = None
        curr = curr.right


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

flatten_iterative(root)

# Print flattened linked list
curr = root
while curr:
    print(curr.val, end=" -> " if curr.right else "")
    curr = curr.right
# Expected: 1 -> 3 -> 2 -> 6 -> 5 -> 4
