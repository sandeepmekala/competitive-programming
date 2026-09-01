# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/
# Companies: Amazon
# Idea: Numbers can be calculated top-down. Pass the number so far to children.
# At leaf nodes, the full number is formed.
# Sum numbers formed by left and right branches.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def sum_numbers(root):
    def helper(node, current_sum):
        if not node:
            return 0

        current_sum = current_sum * 10 + node.val

        # Leaf node
        if not node.left and not node.right:
            return current_sum

        return helper(node.left, current_sum) + helper(node.right, current_sum)

    return helper(root, 0)


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(sum_numbers(root))  # Expected: 132 + 1365 + 14 = 1511
