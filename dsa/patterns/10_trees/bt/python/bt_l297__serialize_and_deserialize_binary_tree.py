# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
# Idea: Encode using preorder traversal with "#" for null nodes.
# Decode by processing preorder list recursively, removing the first element each time.
# Time: O(n)
# Space: O(n)

def serialize(root):
    serialized = []

    def helper(node):
        if not node:
            serialized.append("#")
            return
        serialized.append(str(node.val))
        helper(node.left)
        helper(node.right)

    helper(root)
    return ",".join(serialized)

def deserialize(data):
    serialized = data.split(",")

    def helper(lst):
        val = lst.pop(0)
        if val == "#":
            return None
        node = TreeNode(int(val))
        node.left = helper(lst)
        node.right = helper(lst)
        return node

    return helper(serialized)


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

serialized = serialize(root)
print(serialized)  # Expected: "1,3,2,#,#,6,5,#,#,#,4,#,#"

root_deserialized = deserialize(serialized)

# Optional: inorder traversal to verify
def inorder(node):
    if not node:
        return []
    return inorder(node.left) + [node.val] + inorder(node.right)

print(inorder(root_deserialized))  # Expected: [2, 3, 5, 6, 1, 4]
