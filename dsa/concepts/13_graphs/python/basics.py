"""
1. Initialize weighted adjacency list from list of edges
    (Directed Graph)
"""

n = 8
edges = [
    [0, 6, 7],
    [0, 1, 2],
    [1, 2, 3],
    [1, 3, 3],
    [6, 3, 3],
    [3, 5, 1],
    [6, 5, 1],
    [2, 5, 1],
    [0, 4, 5],
    [4, 6, 2]
]

# adjacency list: node -> list of (neighbor, weight)
adj = [[] for _ in range(n)]

for u, v, w in edges:
    adj[u].append((v, w))

print("Adjacency List (Directed, Weighted):")
for i in range(len(adj)):
    print(f"{i} : {adj[i]}")

print()

"""
2. Graph given directly as adjacency list (unweighted)
"""
graph = [
    [1, 3],
    [0, 2],
    [1, 3],
    [0, 2]
]

print("Adjacency List (Unweighted):")
for i in range(len(graph)):
    print(f"{i} : {graph[i]}")