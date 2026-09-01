# AVL Tree
# Idea:
# 1. Standard BST insertion.
# 2. Track height of each node.
# 3. After insertion, check balance factor.
# 4. Apply rotations if unbalanced: LL, LR, RR, RL.
# Time: O(log n) for insertion
# Space: O(h) recursion stack

class AvlNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.height = 1

class AvlTree:
    def insert(self, root, data):
        if not root:
            return AvlNode(data)

        if data <= root.val:
            root.left = self.insert(root.left, data)
        else:
            root.right = self.insert(root.right, data)

        # Update height
        root.height = 1 + max(self.height(root.left), self.height(root.right))

        # Check balance
        balance = self.height(root.left) - self.height(root.right)

        # LL Rotation
        if balance > 1 and data <= root.left.val:
            return self.rotation_right(root)
        # LR Rotation
        if balance > 1 and data > root.left.val:
            root.left = self.rotation_left(root.left)
            return self.rotation_right(root)
        # RR Rotation
        if balance < -1 and data > root.right.val:
            return self.rotation_left(root)
        # RL Rotation
        if balance < -1 and data <= root.right.val:
            root.right = self.rotation_right(root.right)
            return self.rotation_left(root)

        return root

    def rotation_left(self, root):
        new_root = root.right
        root.right = new_root.left
        new_root.left = root

        root.height = 1 + max(self.height(root.left), self.height(root.right))
        new_root.height = 1 + max(self.height(new_root.left), self.height(new_root.right))
        return new_root

    def rotation_right(self, root):
        new_root = root.left
        root.left = new_root.right
        new_root.right = root

        root.height = 1 + max(self.height(root.left), self.height(root.right))
        new_root.height = 1 + max(self.height(new_root.left), self.height(new_root.right))
        return new_root

    def height(self, node):
        return node.height if node else 0

def inorder(root):
    if root:
        inorder(root.left)
        print(root.val, end=' ')
        inorder(root.right)

# -------- Test --------
avlt = AvlTree()
root = None
for val in [10, 5, 20, -10, 3, 30, 25]:
    root = avlt.insert(root, val)

inorder(root)  # Expected: Inorder traversal of balanced AVL tree
