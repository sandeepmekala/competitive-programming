# Tree / BST
# Problem: https://leetcode.com/problems/delete-node-in-a-bst/
# Idea:
# 1. Perform binary search to find the node to delete.
# 2. Three cases when node is found:
#    a) No child or only right child -> return right.
#    b) Only left child -> return left.
#    c) Two children -> find inorder successor, replace value, and delete successor recursively.
# Time: O(log n)
# Space: O(1) (ignoring recursion stack)

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def deleteNode(root, data):
    if not root:
        return None

    if data < root.val:
        root.left = deleteNode(root.left, data)
    elif data > root.val:
        root.right = deleteNode(root.right, data)
    else:
        # Node to delete found
        if not root.left:          # no child or only right child
            return root.right
        elif not root.right:       # only left child
            return root.left
        else:                      # two children
            successor = findSuccessor(root.right)
            root.val = successor.val
            root.right = deleteNode(root.right, root.val)
    return root

def findSuccessor(node):
    while node.left:
        node = node.left
    return node


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

root = deleteNode(root, 15)

# Helper function to print inorder traversal
def inorder_print(node):
    if not node:
        return
    inorder_print(node.left)
    print(node.val, end=' ')
    inorder_print(node.right)

inorder_print(root)  # Expected: 2 3 4 5 6 10
