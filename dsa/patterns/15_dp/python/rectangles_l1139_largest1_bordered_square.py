# DP / Matrix
#
# Problem: https://leetcode.com/problems/largest-1-bordered-square/
# Idea: Store a point in matrix to track the horizontal and vertical distance
# of 1's that has been seen till now.

def largest1BorderedSquare(grid):
    m = len(grid)
    n = len(grid[0])

    # store horizontal distance of 1's
    hor = [[0] * n for _ in range(m)]
    # store vertical distance of 1's
    ver = [[0] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            if grid[i][j] == 1:
                hor[i][j] = 1 if j == 0 else hor[i][j - 1] + 1
                ver[i][j] = 1 if i == 0 else ver[i - 1][j] + 1

    maximum = 0
    for i in range(m - 1, -1, -1):
        for j in range(n - 1, -1, -1):
            # choose smallest of horizontal and vertical value
            squareSize = min(hor[i][j], ver[i][j])

            while squareSize > maximum:
                # bottom-left vertical && top-right horizontal
                if (
                    ver[i][j - squareSize + 1] >= squareSize and
                    hor[i - squareSize + 1][j] >= squareSize
                ):
                    maximum = squareSize
                squareSize -= 1

    return maximum * maximum


# -------- Test --------
grid = [
    [0,0,0,0,1],
    [1,0,1,1,1],
    [1,0,1,0,1],
    [1,1,1,1,1],
    [0,0,1,1,1]
]

print(largest1BorderedSquare(grid))  # Expected: 9
