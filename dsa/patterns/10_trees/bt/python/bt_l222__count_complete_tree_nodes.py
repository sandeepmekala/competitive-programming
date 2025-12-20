# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/count-complete-tree-nodes/
# Idea: If left and right subtree heights are the same, number of nodes = 2^h - 1.
# Else recursively count nodes in left and right + 1 (for root).
# Time: O(log n * log n)
# Space: O(1) ignoring recursion stack

def count_nodes(root):
    if not root:
        return 0

    def get_left_height(node):
        count = 0
        while node:
            count += 1
            node = node.left
        return count

    def get_right_height(node):
        count = 0
        while node:
            count += 1
            node = node.right
        return count

    l_height = get_left_height(root)
    r_height = get_right_height(root)

    if l_height == r_height:
        return 2 ** l_height - 1
    else:
        return 1 + count_nodes(root.left) + count_nodes(root.right)


# -------- Test --------
root = TreeNode(1)
# root.left = TreeNode(2)
# root.right = TreeNode(3)
# root.left.left = TreeNode(4)
# root.left.right = TreeNode(5)
# root.right.left = TreeNode(6)

print(count_nodes(root))  # Expected: 1 (as only root exists)
