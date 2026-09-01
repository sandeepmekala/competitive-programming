from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
# Idea: Similar to level-order traversal. Use a flag to denote whether to insert elements left-to-right or right-to-left.
# Time: O(n)
# Space: O(n)

def zigzag_level_order(root):
    result = []
    if not root:
        return result

    q = deque([root])
    left_to_right = True

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

        if not left_to_right:
            level.reverse()

        left_to_right = not left_to_right
        result.append(level)

    return result


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(zigzag_level_order(root))  
# Expected: [[1], [4, 3], [2, 6], [5]]
