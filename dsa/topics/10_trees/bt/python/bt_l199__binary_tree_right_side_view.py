# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-right-side-view/
# Idea: Preorder traversal with right child first. Pass level as argument.
# At each level, if size of result equals level, add element.
# Once an element is added at right side, left-side elements are ignored for that level.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def right_side_view(root):
    ans = []

    def preorder(node, level):
        if not node:
            return

        if len(ans) == level:
            ans.append(node.val)

        preorder(node.right, level + 1)
        preorder(node.left, level + 1)

    preorder(root, 0)
    return ans


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(right_side_view(root))  # Expected: [1, 4, 6, 5]
