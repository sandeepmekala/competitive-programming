from typing import List

INF = 100


def get_shortest_paths(adj: List[List[int]]) -> List[List[int]]:
    """
    Floyd–Warshall Algorithm (All-Pairs Shortest Path)

    Idea:
    - Pick an intermediate vertex `via`
    - Check if path i -> via -> j is shorter than direct i -> j
    - If yes, update dist[i][j]

    Notes:
    - Can handle negative edge weights
    - Can detect negative cycles
    - After completion, if dist[i][i] < 0 for any i, a negative cycle exists

    Time Complexity: O(V^3)
    Space Complexity: O(V^2)
    """
    n = len(adj)

    # distance and parent matrices
    dist = [[INF] * n for _ in range(n)]
    parent = [[-1] * n for _ in range(n)]

    # initialization
    for i in range(n):
        for j in range(n):
            if i == j:
                dist[i][j] = 0
            elif adj[i][j] != 0:
                dist[i][j] = adj[i][j]
                parent[i][j] = i

    # floyd-warshall
    for via in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][via] == INF or dist[via][j] == INF:
                    continue
                if dist[i][via] + dist[via][j] < dist[i][j]:
                    dist[i][j] = dist[i][via] + dist[via][j]
                    parent[i][j] = via

    # print parent matrix (same as Java code)
    print("Parent matrix:")
    for row in parent:
        print(row)

    return dist


def has_negative_cycle(dist: List[List[int]]) -> bool:
    """
    If dist[i][i] < 0 after Floyd–Warshall,
    then a negative cycle exists.
    """
    return any(dist[i][i] < 0 for i in range(len(dist)))


if __name__ == "__main__":
    adj = [[0] * 4 for _ in range(4)]
    adj[0][1] = 3
    adj[0][2] = 6
    adj[0][3] = 15
    adj[1][2] = -2
    adj[2][3] = 2
    adj[3][0] = 1

    dist = get_shortest_paths(adj)

    print("\nDistance matrix:")
    for row in dist:
        print(row)

    print("\nNegative cycle present:", has_negative_cycle(dist))
