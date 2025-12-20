# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-preorder-traversal
# Idea: rt-l-r
# Time: O(n)
# Space: O(1) ignoring recursion stack

# Recursive preorder
def preorder_traversal(root):
    result = []

    def helper(node):
        if not node:
            return
        result.append(node.val)
        helper(node.left)
        helper(node.right)

    helper(root)
    return result

# Iterative preorder using stack
# Push right first, then left to stack to explore left first
# Time: O(n)
# Space: O(n)
def preorder_iterative(root):
    if not root:
        return []

    stack = [root]
    preorder = []

    while stack:
        curr = stack.pop()
        preorder.append(curr.val)
        if curr.right:
            stack.append(curr.right)
        if curr.left:
            stack.append(curr.left)

    return preorder

# Morris preorder traversal
# Time: O(n)
# Space: O(1)
def morris_preorder(root):
    preorder = []
    curr = root

    while curr:
        if not curr.left:
            preorder.append(curr.val)
            curr = curr.right
        else:
            prev = curr.left
            while prev.right and prev.right != curr:
                prev = prev.right

            if not prev.right:
                prev.right = curr
                preorder.append(curr.val)  # visiting current node
                curr = curr.left
            else:
                prev.right = None
                curr = curr.right

    return preorder


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(preorder_traversal(root))   # Expected: [1, 3, 2, 6, 5, 4]
print(preorder_iterative(root))   # Expected: same as above
print(morris_preorder(root))      # Expected: same as above
