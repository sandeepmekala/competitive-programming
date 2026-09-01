# Tree / Recursion
# Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
# Idea:
# 1. Pick middle element of the current subarray as root to ensure height-balanced BST.
# 2. Recursively do the same for left subarray (left child) and right subarray (right child).
# Time: O(n)
# Space: O(log n) due to recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def sorted_array_to_bst(nums):
    def helper(start, end):
        if start > end:
            return None
        mid = (start + end) // 2
        root = TreeNode(nums[mid])
        root.left = helper(start, mid - 1)
        root.right = helper(mid + 1, end)
        return root

    return helper(0, len(nums) - 1)


# -------- Test --------
nums = [-10, -3, 0, 5, 9]
root = sorted_array_to_bst(nums)

# Simple print function to verify tree structure (inorder)
def inorder(node):
    return inorder(node.left) + [node.val] + inorder(node.right) if node else []

print(inorder(root))  # Expected: [-10, -3, 0, 5, 9]
