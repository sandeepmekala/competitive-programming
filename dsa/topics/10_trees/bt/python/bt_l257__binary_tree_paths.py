# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-paths/
# Idea: Traverse the tree, keeping the path so far. At leaf nodes, add the complete path to result.
# Time: O(n)
# Space: O(n) ignoring recursion stack

def binary_tree_paths(root):
    result = []

    def helper(node, path):
        if not node:
            return
        if not node.left and not node.right:
            result.append(path + str(node.val))
        else:
            helper(node.left, path + str(node.val) + "->")
            helper(node.right, path + str(node.val) + "->")

    helper(root, "")
    return result


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(binary_tree_paths(root))
# Expected: ['1->3->2', '1->3->6->5', '1->4']
