# Tree / HashSet
# Problem: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
# Idea:
# 1. Similar to two-sum problem.
# 2. Use a set to store visited node values.
# 3. Traverse BST (preorder) and check if k - node.val exists in set.
# 4. Alternative: Use BST iterators with two-pointer technique on sorted nodes.
# Time: O(n)
# Space: O(n) for set

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def findTarget(root, k):
    seen = set()
    
    def dfs(node):
        if not node:
            return False
        if (k - node.val) in seen:
            return True
        seen.add(node.val)
        return dfs(node.left) or dfs(node.right)
    
    return dfs(root)


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

print(findTarget(root, 10))  # Expected: True (e.g., 4 + 6 = 10)
