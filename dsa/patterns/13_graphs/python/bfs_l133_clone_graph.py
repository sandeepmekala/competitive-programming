from collections import deque


class GraphNode:
    def __init__(self, val=0):
        self.val = val
        self.neighbors = []

    def __repr__(self):
        return f"Node({self.val})"


"""
Problem: https://leetcode.com/problems/clone-graph/
Idea:
- Use BFS
- Maintain a map: original_node -> cloned_node
- Map also acts as visited
- First create all nodes
- Then connect neighbors
"""
def cloneGraph(node: GraphNode) -> GraphNode:
    if node is None:
        return None

    # original -> clone
    mp = {}
    mp[node] = GraphNode(node.val)

    q = deque([node])

    # BFS to create all nodes
    while q:
        curr = q.popleft()
        for nei in curr.neighbors:
            if nei not in mp:
                mp[nei] = GraphNode(nei.val)
                q.append(nei)

    # Build edges
    for curr in mp:
        for nei in curr.neighbors:
            mp[curr].neighbors.append(mp[nei])

    return mp[node]


# -------------------- TEST --------------------
if __name__ == "__main__":
    n1 = GraphNode(1)
    n2 = GraphNode(2)
    n3 = GraphNode(3)

    n1.neighbors.append(n2)
    n2.neighbors.append(n3)
    n3.neighbors.append(n1)

    cloned = cloneGraph(n1)

    print("Original:", n1, "Neighbors:", [n.val for n in n1.neighbors])
    print("Cloned  :", cloned, "Neighbors:", [n.val for n in cloned.neighbors])
