# Geometry / Computational Geometry
# Problem: https://www.geeksforgeeks.org/orientation-3-ordered-points/


# To find orientation of ordered triplet (p, q, r).
# slope(p1, p2) = (y2 - y1) / (x2 - x1)
# The function returns following values:
# 0  --> p, q and r are collinear
# 1  --> Clockwise
# -1 --> Counterclockwise
def orientation(p, q, r):
    # slope formula derivation using cross product
    val = (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1])

    if val == 0:
        return 0  # collinear
    return 1 if val > 0 else -1  # clockwise or counterclockwise


# Given three collinear points p, q, r, the function checks if
# point q lies on line segment 'pr'
def on_segment(p, q, r):
    if (q[0] <= max(p[0], r[0]) and q[0] >= min(p[0], r[0]) and
        q[1] <= max(p[1], r[1]) and q[1] >= min(p[1], r[1]) and
        orientation(p, q, r) == 0):
        return True

    return False


# ------------------ Test ------------------

p = (0, 0)
q = (4, 4)
r = (1, 2)

print(orientation(p, q, r))  # Expected: -1 (Counterclockwise)
print(on_segment(p, r, q))   # Expected: True
