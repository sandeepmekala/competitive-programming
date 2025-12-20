from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
# Idea: Process queue level by level. Insert each level at the beginning of result for bottom-up order.
# Time: O(n)
# Space: O(n)

def level_order_bottom(root):
    result = deque()  # Use deque to appendleft efficiently
    if not root:
        return []

    q = deque([root])

    while q:
        level = []
        size = len(q)
        for _ in range(size):
            curr = q.popleft()
            level.append(curr.val)
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
        result.appendleft(level)  # Add at beginning for bottom-up order

    return list(result)  # Convert deque back to list


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(level_order_bottom(root))  
# Expected: [[5], [2, 6], [3, 4], [1]]
