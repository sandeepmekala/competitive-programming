# Tree / BST
# Problem: https://leetcode.com/problems/validate-binary-search-tree/
# Idea:
# 1. Pass min and max values to each recursive call.
# 2. Each node must be in range (min, max).
# 3. Immediate child might satisfy BST but grandchild could violate it.
# Time: O(n)
# Space: O(h) recursion stack

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def is_valid_bst(root):
    def helper(node, min_val, max_val):
        if not node:
            return True
        if not (min_val < node.val < max_val):
            return False
        return helper(node.left, min_val, node.val) and helper(node.right, node.val, max_val)
    
    return helper(root, float('-inf'), float('inf'))


# -------- Test --------
# Helper to insert into BST
def insert_into_bst(root, val):
    if not root:
        return TreeNode(val)
    if val < root.val:
        root.left = insert_into_bst(root.left, val)
    else:
        root.right = insert_into_bst(root.right, val)
    return root

# Construct BST
root = None
for val in [10, 2, 4, 6, 5, 15, 3]:
    root = insert_into_bst(root, val)

print(is_valid_bst(root))  # Expected: False (this tree violates BST rules)
