from typing import List

def find_the_city(n: int, edges: List[List[int]], distance_threshold: int) -> int:
    """
    Problem: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

    Idea:
    - Apply Floyd–Warshall to compute all-pairs shortest paths
    - For each city, count how many cities are reachable within distanceThreshold
    - Pick the city with the smallest count
    - If there is a tie, return the city with the greater index

    Time: O(n^3)
    Space: O(n^2)
    """
    INF = 10**9

    # initialize distance matrix
    dist = [[INF] * n for _ in range(n)]
    for i in range(n):
        dist[i][i] = 0

    # fill edges
    for u, v, w in edges:
        dist[u][v] = w
        dist[v][u] = w

    # Floyd–Warshall
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][k] == INF or dist[k][j] == INF:
                    continue
                if dist[i][k] + dist[k][j] < dist[i][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]

    # find city with minimum reachable neighbors
    min_count = n
    city = -1
    for i in range(n):
        count = 0
        for j in range(n):
            if dist[i][j] <= distance_threshold:
                count += 1
        # <= ensures we pick the city with larger index on tie
        if count <= min_count:
            min_count = count
            city = i

    return city


# one test (same as Java main)
if __name__ == "__main__":
    edges = [[0, 1, 3], [1, 2, 1], [1, 3, 4], [2, 3, 1]]
    print(find_the_city(4, edges, 4))  # expected output: 3
