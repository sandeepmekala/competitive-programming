# Red-Black Tree
# Rules:
# 1. Root is always black
# 2. No red-red parent-child relation
# 3. Every path from root to leaves has same number of black nodes
# Idea:
# Maintain a BST with an extra color property (RED/BLACK)
# Apply rotations and color flips during insertions to maintain properties

class Color:
    RED = 0
    BLACK = 1

class RbNode:
    def __init__(self, val, color=Color.RED):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None
        self.color = color

class RedBlackTree:
    def __init__(self):
        self.root = None

    def insert(self, val):
        # BST insert first
        new_node = RbNode(val)
        if not self.root:
            self.root = new_node
        else:
            parent = None
            curr = self.root
            while curr:
                parent = curr
                if val < curr.val:
                    curr = curr.left
                else:
                    curr = curr.right
            new_node.parent = parent
            if val < parent.val:
                parent.left = new_node
            else:
                parent.right = new_node
        # Fix violations
        self.fix_insert(new_node)

    def fix_insert(self, node):
        # Placeholder for fixing red-black properties after insert
        # Apply rotations and color flips as per standard RBT rules
        pass

    def inorder(self, node):
        if node:
            self.inorder(node.left)
            print(f"{node.val} ({'R' if node.color == Color.RED else 'B'})", end=' ')
            self.inorder(node.right)

# -------- Test scaffold --------
rbt = RedBlackTree()
for val in [10, 5, 20, 3, 8, 15, 25]:
    rbt.insert(val)

rbt.inorder(rbt.root)  # Will print nodes with colors
