# Tree / Linked List / Recursion
# Problem: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
# Idea:
# 1. Use in-order simulation: left subtree -> root -> right subtree.
# 2. Pass the size of the list to recursively split elements.
# 3. Maintain a pointer to the current head, moving it as root nodes are created.
# Time: O(n)
# Space: O(log n) due to recursion stack

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def sorted_list_to_bst(head, n):
    # head_ref is a list so it can be modified inside recursion
    head_ref = [head]

    def build_bst(size):
        if size <= 0:
            return None

        # Build left subtree
        left = build_bst(size // 2)

        # Current root
        root_val = head_ref[0].val
        root = TreeNode(root_val)
        head_ref[0] = head_ref[0].next

        # Build right subtree
        right = build_bst(size - size // 2 - 1)
        root.left = left
        root.right = right

        return root

    return build_bst(n)


# -------- Test --------
# Creating sorted linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
head = ListNode(1)
curr = head
for val in range(2, 8):
    curr.next = ListNode(val)
    curr = curr.next

n = 7
root = sorted_list_to_bst(head, n)

# Pre-order traversal to verify tree
def preorder(node):
    if not node:
        return []
    return [node.val] + preorder(node.left) + preorder(node.right)

print(preorder(root))  # Expected: [4,2,1,3,6,5,7] (one valid BST structure)
