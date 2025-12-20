# Problem: https://leetcode.com/problems/erect-the-fence/
# Idea: Use Jarvis March or Gift Wrapping algorithm.
# Start with left most point and go in counter clock wise direction.
# Find the right most q and use it as next
def outer_trees(trees):
    fence = set()
    n = len(trees)

    # Find the leftmost point
    start = 0
    for i in range(1, n):
        if trees[i][0] < trees[start][0]:
            start = i

    # Start from leftmost point, keep moving counter clock wise until reach the start point again.
    # This loop runs O(h) times where h is number of points in result or output.
    curr = start
    while True:
        fence.add(tuple(trees[curr]))

        # Search for a point 'q' such that orientation(p, q, x)
        # is counter clock wise for all points 'x'
        next_ind = (curr + 1) % n
        for i in range(n):
            if i == curr or i == next_ind:
                continue

            # If i is more counter clock wise than current q, then update q
            if orientation(trees[curr], trees[i], trees[next_ind]) == -1:
                next_ind = i

        # Handle collinear points
        for i in range(n):
            if i == curr or i == next_ind:
                continue

            if orientation(trees[curr], trees[i], trees[next_ind]) == 0:
                fence.add(tuple(trees[i]))

        curr = next_ind
        if curr == start or len(fence) == n:
            break

    return [list(p) for p in fence]


def orientation(p, q, r):
    # slope formula derivation
    val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])

    if val == 0:
        return 0    # collinear
    return 1 if val > 0 else -1   # clock or counterclock wise


# ------------------ Test (Same as Java main) ------------------

points = [
    # [0, 3],[2, 3],[1, 1],[2, 1],[3, 0],[0, 0]
    # [1,1],[2,2],[2,0],[2,4],[3,3],[4,2]
    [0, 5], [10, 0], [10, 10], [0, 10], [0, 0]
]

result = outer_trees(points)
for p in result:
    print(p)
