# Tree / HashMap
# Problem: https://leetcode.com/problems/find-mode-in-binary-search-tree/
# Idea:
# 1. Traverse the BST (preorder) and count occurrences of each value.
# 2. Track the maximum frequency.
# 3. Collect all values with max frequency as the mode(s).
# Time: O(n)
# Space: O(n) for hashmap

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def find_mode(root):
    from collections import defaultdict
    count = defaultdict(int)
    max_freq = [0]  # use list to allow modification inside nested function

    def preorder(node):
        if not node:
            return
        count[node.val] += 1
        max_freq[0] = max(max_freq[0], count[node.val])
        preorder(node.left)
        preorder(node.right)

    preorder(root)

    # Collect all values with frequency == max
    result = [val for val, freq in count.items() if freq == max_freq[0]]
    return result


# -------- Test --------
root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(4)
root.left.left = TreeNode(2)
root.left.right = TreeNode(6)
root.left.right.left = TreeNode(5)

print(find_mode(root))  # Example output: [1,2,3,4,5,6] depending on tree values frequency
