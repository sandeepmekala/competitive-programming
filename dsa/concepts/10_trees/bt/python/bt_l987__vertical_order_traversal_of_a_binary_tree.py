# Binary Tree + BFS + Sorting
# Problem: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
# Idea:
# 1. Map each node to 2D coordinates (row, col) using BFS.
# 2. Use nested dictionaries: col -> row -> min-heap of node values.
# 3. After BFS, extract values in order: sorted columns, sorted rows, sorted node values.
# Time: O(n log n) (due to sorting of rows and min-heaps)
# Space: O(n)

from collections import deque, defaultdict
import heapq

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class VerticalTuple:
    def __init__(self, node, row, col):
        self.node = node
        self.row = row
        self.col = col

def vertical_traversal(root):
    if not root:
        return []

    # col -> row -> min-heap of node values
    node_map = defaultdict(lambda: defaultdict(list))
    q = deque([VerticalTuple(root, 0, 0)])

    while q:
        curr = q.popleft()
        node, row, col = curr.node, curr.row, curr.col
        heapq.heappush(node_map[col][row], node.val)

        if node.left:
            q.append(VerticalTuple(node.left, row + 1, col - 1))
        if node.right:
            q.append(VerticalTuple(node.right, row + 1, col + 1))

    ans = []
    for col in sorted(node_map.keys()):
        col_nodes = []
        for row in sorted(node_map[col].keys()):
            while node_map[col][row]:
                col_nodes.append(heapq.heappop(node_map[col][row]))
        ans.append(col_nodes)

    return ans

# -------- Test --------
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

print(vertical_traversal(root))  # Expected: [[9], [3, 15], [20], [7]]
