# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/construct-binary-tree-from-postorder-and-inorder-traversal/
# Idea: Last element in postorder is root. Find it in inorder to split left/right subtrees.
# Recursively build left and right subtrees.
# Time: O(n)
# Space: O(n)

def build_tree_from_post_in(inorder, postorder):
    in_index_map = {val: idx for idx, val in enumerate(inorder)}

    def helper(ist, ied, pst, ped):
        if pst > ped or ist > ied:
            return None

        root_val = postorder[ped]
        root = TreeNode(root_val)

        root_idx_in_inorder = in_index_map[root_val]
        nums_left = root_idx_in_inorder - ist

        # Build left subtree
        root.left = helper(ist, root_idx_in_inorder - 1, pst, pst + nums_left - 1)
        # Build right subtree
        root.right = helper(root_idx_in_inorder + 1, ied, pst + nums_left, ped - 1)

        return root

    return helper(0, len(inorder) - 1, 0, len(postorder) - 1)


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

inorder_list = [9,15,7,20,3]
postorder = [9,3,15,20,7]  # matches Java example
root = build_tree_from_post_in(inorder_list, postorder)
print(inorder_traversal(root))  # Expected: [9, 15, 7, 20, 3]
