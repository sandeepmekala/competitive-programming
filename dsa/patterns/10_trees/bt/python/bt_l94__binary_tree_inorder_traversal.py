# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/
# Idea: l-rt-r

# -> Root level is 0
# -> Level l can contain at most 2^l nodes
# -> Height is the number of levels that tree has
# -> Max nodes in tree is 2^h-1
# -> In BT of n nodes minimum possible height is log(n+1) and max height is n.

# -> Full BT: Each node has 0 or 2 children
# -> Complete BT: All nodes have 2 children and last level is filled from left
# -> Perfect BT: All nodes have 2 children and all leaves are at same level
# -> Balanced BT: Height log(n)
#		-> AVL: Diff of left and right subtree height <= 1
#		-> RB: Same number of black nodes from root to leaf; no adjacent red nodes
# -> Degenerate(pathological) Tree: Every node has single child (like linked list)
# -> Traversals:
#		-> Inorder - L-Rt-R
# 		-> Preorder - Rt-L-R
# 		-> Postorder - L-R-Rt
# 		-> Breadth first(level order)


# Recursive Inorder
def inorder_traversal(root):
    result = []

    def helper(node):
        if not node:
            return
        helper(node.left)
        result.append(node.val)
        helper(node.right)

    helper(root)
    return result


# Iterative Inorder using stack
# Idea: Store all elements in stack until left becomes None.
# Once left is None, take root from stack, add to list, move to right.
# Time: O(n)
# Space: O(n)
def inorder_iterative(root):
    if not root:
        return []

    stack = []
    inorder = []
    curr = root

    while curr or stack:
        if curr:
            stack.append(curr)
            curr = curr.left
        else:
            curr = stack.pop()
            inorder.append(curr.val)
            curr = curr.right

    return inorder


# Morris Inorder
# Idea: Build temporary link from predecessor's rightmost to current.
# When left is None, use link to go up. Reset link when revisiting predecessor.
# Time: O(n)
# Space: O(1)
def morris_inorder(root):
    inorder = []
    curr = root

    while curr:
        if not curr.left:
            inorder.append(curr.val)
            curr = curr.right
        else:
            prev = curr.left
            while prev.right and prev.right != curr:
                prev = prev.right

            if not prev.right:
                prev.right = curr
                curr = curr.left
            else:
                prev.right = None
                inorder.append(curr.val)
                curr = curr.right

    return inorder


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(inorder_traversal(root))      # Expected: [2, 3, 5, 6, 3, 1, 4]
print(inorder_iterative(root))      # Expected: same as above
print(morris_inorder(root))         # Expected: same as above
