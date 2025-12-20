# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/path-sum/
# Idea: Subtract root value from target sum until it becomes 0 at leaf node.
# Time: O(n)
# Space: O(1) ignoring recursion stack

def has_path_sum(root, target_sum):
    if not root:
        return False

    target_sum -= root.val
    if not root.left and not root.right:
        return target_sum == 0

    return has_path_sum(root.left, target_sum) or has_path_sum(root.right, target_sum)


# Optional: get the actual path that sums to target
def path_sum(root, target_sum):
    path = []

    def helper(node, remaining):
        if not node:
            return False

        remaining -= node.val

        # Check leaf node
        if not node.left and not node.right and remaining == 0:
            path.append(node.val)
            return True

        if helper(node.left, remaining) or helper(node.right, remaining):
            path.append(node.val)
            return True

        return False

    helper(root, target_sum)
    path.reverse()  # Reverse to get root-to-leaf order
    return path


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(has_path_sum(root, 6))   # Expected: True
print(path_sum(root, 6))       # Expected_
