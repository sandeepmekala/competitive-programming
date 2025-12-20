# Tree / Stack
# Problem: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
# Idea:
# 1. Use iterative in-order traversal to get nodes in sorted order.
# 2. Keep count of nodes visited.
# 3. Return the value when count == k.
# 4. Can also use Morris traversal to reduce space.
# Time: O(log n) on average
# Space: O(log n)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def kthSmallest(root, k):
    stack = []
    curr = root
    count = 0

    while curr or stack:
        if curr:
            stack.append(curr)
            curr = curr.left
        else:
            curr = stack.pop()
            count += 1
            if count == k:
                return curr.val
            curr = curr.right

    return -1


# -------- Test --------
# Helper function to insert into BST
def insertIntoBST(root, val):
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insertIntoBST(root.left, val)
    else:
        root.right = insertIntoBST(root.right, val)
    return root

root = None
for val in [10, 2, 4, 6, 5, 15, 3]:
    root = insertIntoBST(root, val)

print(kthSmallest(root, 3))  # Expected: 4
