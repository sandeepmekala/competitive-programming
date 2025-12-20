# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: Convert a binary tree to satisfy children sum property
# Time: O(n)
# Space: O(1) (ignoring recursion stack)

def change_tree(root):
    if not root:
        return

    # Compute sum of children
    child_sum = 0
    if root.left:
        child_sum += root.left.val
    if root.right:
        child_sum += root.right.val

    # If children sum < root, increment children
    if child_sum < root.val:
        if root.left:
            root.left.val = root.val
        elif root.right:
            root.right.val = root.val

    # Recur for left and right subtrees
    change_tree(root.left)
    change_tree(root.right)

    # Update root's value to sum of children if it has any child
    total_sum = 0
    if root.left:
        total_sum += root.left.val
    if root.right:
        total_sum += root.right.val

    if root.left or root.right:
        root.val = total_sum


# -------- Test --------
root = TreeNode(50)
root.left = TreeNode(7)
root.right = TreeNode(2)
root.left.left = TreeNode(3)
root.left.right = TreeNode(5)
root.right.left = TreeNode(1)
root.right.right = TreeNode(30)

change_tree(root)

# Function to do level order traversal for checking result
from collections import deque
def level_order(root):
    if not root:
        return []
    q = deque([root])
    res = []
    while q:
        node = q.popleft()
        res.append(node.val)
        if node.left:
            q.append(node.left)
        if node.right:
            q.append(node.right)
    return res

print(level_order(root))  # Expected: [50, 50, 50, 3, 5, 30, 30]
