# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

# Problem: https://leetcode.com/problems/binary-tree-postorder-traversal/
# Idea: l-r-rt
# Time: O(n)
# Space: O(1) ignoring recursion stack

# Recursive postorder
def postorder_traversal(root):
    result = []

    def helper(node):
        if not node:
            return
        helper(node.left)
        helper(node.right)
        result.append(node.val)

    helper(root)
    return result

# Iterative using two stacks
# Time: O(n)
# Space: O(n)
def postorder_iterative_two_stacks(root):
    if not root:
        return []

    stack1 = [root]
    stack2 = []
    while stack1:
        curr = stack1.pop()
        stack2.append(curr)
        if curr.left:
            stack1.append(curr.left)
        if curr.right:
            stack1.append(curr.right)

    return [node.val for node in reversed(stack2)]  # equivalent to popping from stack2

# Iterative using one stack
# Time: O(n)
# Space: O(n)
def postorder_iterative_one_stack(root):
    if not root:
        return []

    stack = []
    postorder = []
    curr = root

    while stack or curr:
        if curr:
            stack.append(curr)
            curr = curr.left
        else:
            right = stack[-1].right
            if not right:
                right = stack.pop()
                postorder.append(right.val)
                while stack and right == stack[-1].right:
                    right = stack.pop()
                    postorder.append(right.val)
            else:
                curr = right

    return postorder


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(postorder_traversal(root))             # Expected: [2, 5, 6, 3, 4, 1]
print(postorder_iterative_two_stacks(root))  # Expected: same as above
print(postorder_iterative_one_stack(root))   # Expected: same as above
