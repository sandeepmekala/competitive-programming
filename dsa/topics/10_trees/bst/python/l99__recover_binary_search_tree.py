# Tree
# Problem: https://leetcode.com/problems/recover-binary-search-tree/
# Idea:
# 1. Perform in-order traversal of BST.
# 2. Keep track of previous node.
# 3. Detect violations where current node value < previous node value.
# 4. Swap the first and last nodes if two violations, else first and middle if one violation.
# Time: O(n)
# Space: O(1) (ignoring recursion stack)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

prev = None
first = None
middle = None
last = None

def recoverTree(root):
    global prev, first, middle, last
    prev = TreeNode(float('-inf'))
    first = middle = last = None

    def inorder(root):
        global prev, first, middle, last
        if not root:
            return
        inorder(root.left)
        if root.val < prev.val:
            if first is None:  # first violation
                first = prev
                middle = root
            else:  # second violation
                last = root
        prev = root
        inorder(root.right)

    inorder(root)

    if first and last:
        first.val, last.val = last.val, first.val
    elif first and middle:
        first.val, middle.val = middle.val, first.val


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.left.right = TreeNode(2)

recoverTree(root)

# Function to do inorder traversal and print tree values
def inorder_print(node):
    if not node:
        return
    inorder_print(node.left)
    print(node.val, end=' ')
    inorder_print(node.right)

inorder_print(root)  # Expected output: 2 3 1
