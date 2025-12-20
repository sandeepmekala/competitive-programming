"""
Problem: https://leetcode.com/problems/image-smoother/
Idea:
- Traverse each cell of the matrix
- For each cell, look at its 8 neighbors + itself
- Calculate sum and count of valid neighbors
- Average = sum // count
"""
def imageSmoother(img):
    m, n = len(img), len(img[0])

    directions = [
        (-1, -1), (-1, 0), (-1, 1),
        (0, -1),  (0, 0),  (0, 1),
        (1, -1),  (1, 0),  (1, 1)
    ]

    result = [[0] * n for _ in range(m)]

    for i in range(m):
        for j in range(n):
            total = 0
            count = 0

            for dx, dy in directions:
                ni, nj = i + dx, j + dy
                if 0 <= ni < m and 0 <= nj < n:
                    total += img[ni][nj]
                    count += 1

            result[i][j] = total // count

    return result


# -------------------- TEST --------------------
if __name__ == "__main__":
    img = [
        [100, 200, 100],
        [200,  50, 200],
        [100, 200, 100]
    ]

    smoothed = imageSmoother(img)
    for row in smoothed:
        print(row)
