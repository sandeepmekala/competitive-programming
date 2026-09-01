from typing import List


class GraphMatrix:
    def __init__(self, vertices: int):
        self.V = vertices
        self.adj_matrix = [[float("inf")] * vertices for _ in range(vertices)]

    def add_edge(self, src: int, dest: int, weight: int) -> None:
        self.adj_matrix[src][dest] = weight


"""
Problem:
Travelling Salesman Problem (TSP) using Nearest Neighbour heuristic.

Idea:
- Start from a given city.
- Repeatedly visit the nearest unvisited city.
- Continue until no unvisited neighbor is reachable.
- If all vertices are visited, return to the start city to complete the cycle.

Note:
This is a greedy heuristic solution.
It does NOT guarantee the optimal TSP solution.

Time:  O(V²)
Space: O(V)
"""
def tsp_nearest_neighbour(graph: GraphMatrix, start: int) -> List[int]:
    visited = [False] * graph.V
    path = []

    curr = start
    visited[curr] = True
    path.append(curr)

    for _ in range(graph.V - 1):
        next_node = -1
        min_weight = float("inf")

        for i in range(graph.V):
            if not visited[i] and graph.adj_matrix[curr][i] < min_weight:
                min_weight = graph.adj_matrix[curr][i]
                next_node = i

        if next_node == -1:
            print("No path exists to cover all nodes")
            return []

        visited[next_node] = True
        path.append(next_node)
        curr = next_node

    # return to start to complete the cycle
    path.append(start)
    return path


# ------------ test (same as Java main) ------------
if __name__ == "__main__":
    g = GraphMatrix(5)

    g.add_edge(0, 1, 2)
    g.add_edge(1, 0, 3)
    g.add_edge(1, 2, 4)
    g.add_edge(2, 1, 5)
    g.add_edge(2, 3, 1)
    g.add_edge(3, 2, 10)
    g.add_edge(3, 0, 4)
    g.add_edge(0, 3, 1)

    print(tsp_nearest_neighbour(g, 0))
