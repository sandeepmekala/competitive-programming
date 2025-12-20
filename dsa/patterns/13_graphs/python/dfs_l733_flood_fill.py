"""
Problem:
https://leetcode.com/problems/flood-fill/

Idea:
- Perform DFS from the starting cell (sr, sc)
- Store the original source color
- Recursively move in 4 directions
- If the current cell color matches the source color,
  repaint it with the new color
- Stop recursion when out of bounds or color doesn't match

Time: O(m * n)
Space: O(m * n)  (recursion stack)
"""


def flood_fill(image, sr, sc, color):
    src_color = image[sr][sc]

    # If source color and new color are same, no change needed
    if src_color == color:
        return image

    dfs(image, sr, sc, src_color, color)
    return image


"""
DFS to repaint connected pixels
"""


def dfs(image, i, j, src_color, new_color):
    if not is_safe(image, i, j, src_color):
        return

    image[i][j] = new_color

    dfs(image, i + 1, j, src_color, new_color)
    dfs(image, i - 1, j, src_color, new_color)
    dfs(image, i, j + 1, src_color, new_color)
    dfs(image, i, j - 1, src_color, new_color)


"""
Check if cell is inside grid and matches source color
"""


def is_safe(image, i, j, src_color):
    m, n = len(image), len(image[0])
    return (
        0 <= i < m and
        0 <= j < n and
        image[i][j] == src_color
    )


# -------------------- TEST --------------------
if __name__ == "__main__":
    image = [
        [1, 1, 1],
        [1, 1, 0],
        [1, 0, 1]
    ]

    result = flood_fill(image, 1, 1, 2)
    for row in result:
        print(row)
