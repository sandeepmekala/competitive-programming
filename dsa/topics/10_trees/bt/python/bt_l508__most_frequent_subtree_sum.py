from collections import defaultdict
from typing import List

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/most-frequent-subtree-sum/
# Companies: Amazon
# Idea: subtree sum = root.val + left + right
# Store subtree sums in a map and track max frequency
# Time: O(n)
# Space: O(n)

def find_frequent_tree_sum(root: TreeNode) -> List[int]:
    count = defaultdict(int)
    max_freq = 0

    def helper(node):
        nonlocal max_freq
        if not node:
            return 0
        left = helper(node.left)
        right = helper(node.right)
        s = node.val + left + right
        count[s] += 1
        max_freq = max(max_freq, count[s])
        return s

    helper(root)
    return [s for s, freq in count.items() if freq == max_freq]


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

result = find_frequent_tree_sum(root)
print(result)  # Expected: subtree sums with highest frequency
