# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
# Idea: First element in preorder is root. Find it in inorder to split left/right subtrees.
# Recursively build left and right subtrees.
# Time: O(n)
# Space: O(n)

def build_tree(preorder, inorder):
    in_index_map = {val: idx for idx, val in enumerate(inorder)}

    def helper(pst, ped, ist, ied):
        if pst > ped or ist > ied:
            return None

        root_val = preorder[pst]
        root = TreeNode(root_val)

        root_idx_in_inorder = in_index_map[root_val]
        nums_left = root_idx_in_inorder - ist

        # Build left subtree
        root.left = helper(pst + 1, pst + nums_left, ist, root_idx_in_inorder - 1)
        # Build right subtree
        root.right = helper(pst + nums_left + 1, ped, root_idx_in_inorder + 1, ied)

        return root

    return helper(0, len(preorder) - 1, 0, len(inorder) - 1)


# -------- Test --------
# Reusing inorder traversal from previous example
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

preorder = [3,9,20,15,7]
inorder_list = [9,3,15,20,7]
root = build_tree(preorder, inorder_list)
print(inorder_traversal(root))  # Expected: [9, 3, 15, 20, 7]
