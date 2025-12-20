# Tree / BST / Preorder
# Problem: https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
# Idea:
# 1. Pass an upper bound from top to bottom.
# 2. If current element in preorder is within the bound, create a node.
# 3. For left child, the current node value becomes the upper bound.
# 4. For right child, the bound from parent is maintained.
# Time: O(n)
# Space: O(n) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def bstFromPreorder(preorder):
    index = [0]  # mutable index to keep track of current element

    def helper(bound):
        if index[0] == len(preorder) or preorder[index[0]] > bound:
            return None
        root_val = preorder[index[0]]
        index[0] += 1
        root = TreeNode(root_val)
        root.left = helper(root_val)
        root.right = helper(bound)
        return root

    return helper(float('inf'))


# -------- Test --------
preorder = [8, 5, 1, 7, 10, 12]
root = bstFromPreorder(preorder)

# Helper function to print inorder traversal
def inorder_print(node):
    if not node:
        return
    inorder_print(node.left)
    print(node.val, end=' ')
    inorder_print(node.right)

inorder_print(root)  # Expected inorder: 1 5 7 8 10 12
