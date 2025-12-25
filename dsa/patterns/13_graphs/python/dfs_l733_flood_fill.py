# Problem:
# https://leetcode.com/problems/flood-fill/
#
# Idea:
# - Perform DFS from the starting cell (sr, sc)
# - Store the original source color
# - Recursively move in 4 directions
# - If the current cell color matches the source color,
#   repaint it with the new color
# - Stop recursion when out of bounds or color doesn't match
#
# Time: O(m * n)
# Space: O(m * n)  (recursion stack)


def flood_fill(image, sr, sc, color):
    rows, cols = len(image), len(image[0])
    src_color = image[sr][sc]

    # If source color and new color are same, no change needed
    if src_color == color:
        return image

    # DFS to repaint connected pixels
    def dfs(r, c):
        # Check if cell is inside grid and matches source color
        if not (0 <= r < rows and 0 <= c < cols):
            return
        if image[r][c] != src_color:
            return

        image[r][c] = color

        for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            dfs(r + dr, c + dc)

    dfs(sr, sc)
    return image


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
