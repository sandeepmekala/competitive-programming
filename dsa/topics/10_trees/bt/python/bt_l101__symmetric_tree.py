# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/symmetric-tree/
# Idea: Use two parameters representing left and right subtrees which are symmetric clones.
# Recursively, pass corresponding symmetric roots.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def is_symmetric(root):
    if not root:
        return True

    def check(left, right):
        if not left or not right:
            return left is right

        return (left.val == right.val and
                check(left.left, right.right) and
                check(left.right, right.left))

    return check(root.left, root.right)


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(2)
root.left.left = TreeNode(3)
root.right.right = TreeNode(3)

print(is_symmetric(root))  # Expected: True
