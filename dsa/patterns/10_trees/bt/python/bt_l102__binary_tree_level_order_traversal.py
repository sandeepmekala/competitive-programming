from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-level-order-traversal/
# Idea: Use queue size to process nodes level by level. Add children to queue.
# Time: O(n)
# Space: O(n)

def level_order(root):
    ans = []
    if not root:
        return ans

    q = deque([root])

    while q:
        level = []
        size = len(q)  # Store current level size as queue size changes
        for _ in range(size):
            curr = q.popleft()
            level.append(curr.val)
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
        ans.append(level)

    return ans


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(level_order(root))  
# Expected: [[1], [3, 4], [2, 6], [5]]
