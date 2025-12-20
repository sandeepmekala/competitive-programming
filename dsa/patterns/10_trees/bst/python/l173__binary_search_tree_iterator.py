# Tree / Stack
# Problem: https://leetcode.com/problems/binary-search-tree-iterator/
# Idea:
# 1. The first processed element is the leftmost node.
# 2. Push all left children to stack so that leftmost is on top.
# 3. When processing a node, if it has a right child, push all its left children to stack.
# Time: O(log n) amortized
# Space: O(log n)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BSTIterator:
    def __init__(self, root):
        self.stack = []
        curr = root
        while curr:
            self.stack.append(curr)
            curr = curr.left

    def next(self):
        next_node = self.stack.pop()
        curr = next_node.right
        while curr:
            self.stack.append(curr)
            curr = curr.left
        return next_node.val

    def hasNext(self):
        return len(self.stack) > 0


# -------- Test --------
# Construct BST: 
#        7
#       / \
#      3   15
#          / \
#         9  20
root = TreeNode(7)
root.left = TreeNode(3)
root.right = TreeNode(15, TreeNode(9), TreeNode(20))

iterator = BSTIterator(root)
result = []
while iterator.hasNext():
    result.append(iterator.next())
print(result)  # Expected: [3, 7, 9, 15, 20]
