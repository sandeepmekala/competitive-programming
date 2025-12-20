# Tree / DFS
# Problem: https://www.lintcode.com/problem/910/
# Idea:
# 1. Use a helper structure NodeState (size, min, max) for each subtree.
# 2. If current node satisfies BST property w.r.t left and right subtree, update size, min, max.
# 3. Otherwise, propagate the largest size found so far but invalidate min/max for BST check.
# Time: O(n)
# Space: O(1) (ignoring recursion stack)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class NodeState:
    def __init__(self, size, min_val, max_val):
        self.size = size
        self.min = min_val
        self.max = max_val

MAX_INT = float('inf')
MIN_INT = float('-inf')

def maxSumBST(root):
    def maxSizeBstRec(node):
        if not node:
            return NodeState(0, MAX_INT, MIN_INT)  # empty tree is BST of size 0
        
        left = maxSizeBstRec(node.left)
        right = maxSizeBstRec(node.right)
        
        if node.val > left.max and node.val < right.min:
            size = left.size + right.size + 1
            min_val = min(left.min, node.val)
            max_val = max(right.max, node.val)
            return NodeState(size, min_val, max_val)
        else:
            return NodeState(max(left.size, right.size), MIN_INT, MAX_INT)
    
    return maxSizeBstRec(root).size


# -------- Test --------
root = TreeNode(6)
root.left = TreeNode(3)
root.right = TreeNode(5)
root.left.right = TreeNode(2)
root.right.left = TreeNode(0)
root.left.right.right = TreeNode(1)

print(maxSumBST(root))  # Expected: size of largest BST subtree
