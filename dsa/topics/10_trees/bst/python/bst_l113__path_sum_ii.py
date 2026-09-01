# Tree / Backtracking
# Problem: https://leetcode.com/problems/path-sum-ii/
# Companies: Amazon
# Idea:
# 1. Use backtracking to explore all root-to-leaf paths.
# 2. Add node value to path when entering, remove when exiting.
# 3. If leaf node and sum equals target, add a copy of path to result.
# Time: O(n)
# Space: O(n) recursion stack + path storage

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def path_sum(root, target_sum):
    result = []

    def dfs(node, remaining_sum, path):
        if not node:
            return

        # Add current node to path
        path.append(node.val)

        # Check if leaf and sum matches
        if not node.left and not node.right and remaining_sum == node.val:
            result.append(list(path))  # append a copy

        # Recurse left and right
        dfs(node.left, remaining_sum - node.val, path)
        dfs(node.right, remaining_sum - node.val, path)

        # Backtrack
        path.pop()

    dfs(root, target_sum, [])
    return result


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(path_sum(root, 6))  # Expected: [[1,3,2], [1,3,6,5]] depending on tree
