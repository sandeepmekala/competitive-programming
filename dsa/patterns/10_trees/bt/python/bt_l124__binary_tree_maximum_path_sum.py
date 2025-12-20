# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-maximum-path-sum/
# Idea: Similar to finding max diameter.
# Ignore negative path sums by taking max with 0 to skip negative paths.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def max_path_sum(root):
    max_sum = float('-inf')

    def helper(node):
        nonlocal max_sum
        if not node:
            return 0

        left_sum = max(0, helper(node.left))
        right_sum = max(0, helper(node.right))

        # Max path sum through current node
        path_sum = node.val + left_sum + right_sum
        max_sum = max(max_sum, path_sum)

        # Return max sum path extending to parent
        return node.val + max(left_sum, right_sum)

    helper(root)
    return max_sum


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(max_path_sum(root))  # Expected: 21 (path: 2 -> 3 -> 6 -> 5 -> 4)
