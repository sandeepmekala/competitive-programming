from collections import deque

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/maximum-width-of-binary-tree/
# Idea: Index each node in BT similar to segment tree with 2*i+1, 2*i+2.
# Width is difference of last node and first node indices in each level. Take max of it.
# Time: O(n)
# Space: O(n) due to queue

def width_of_binary_tree(root):
    if not root:
        return 0

    ans = 0
    # queue stores tuples of (node, index)
    q = deque([(root, 0)])

    while q:
        size = len(q)
        min_index = q[0][1]
        first, last = 0, 0

        for i in range(size):
            node, index = q.popleft()
            index -= min_index  # normalize to prevent overflow

            if i == 0:
                first = index
            if i == size - 1:
                last = index

            if node.left:
                q.append((node.left, 2 * index + 1))
            if node.right:
                q.append((node.right, 2 * index + 2))

        ans = max(ans, last - first + 1)

    return ans


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(2)
root.left.left = TreeNode(5)
root.left.right = TreeNode(3)
root.right.right = TreeNode(9)

print(width_of_binary_tree(root))  # Expected: 4
