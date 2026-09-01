# Geometry / Computational Geometry
# Problem: https://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/


# To find orientation of ordered triplet (p, q, r).
# slope(p1, p2) = (y2 - y1) / (x2 - x1)
# The function returns following values:
# 0  --> p, q and r are collinear
# 1  --> Clockwise
# -1 --> Counterclockwise
def orientation(p, q, r):
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


# The main function that checks whether the line segment 'p1q1'
# and 'p2q2' intersect
def intersect(p1, q1, p2, q2):
    # Find the four orientations needed for general and special cases
    o1 = orientation(p1, q1, p2)
    o2 = orientation(p1, q1, q2)
    o3 = orientation(p2, q2, p1)
    o4 = orientation(p2, q2, q1)

    # General case: perfect + kind of intersection
    if o1 != o2 and o3 != o4:
        return True

    # Special Cases
    # p1, q1 and p2 are collinear and p2 lies on segment p1q1
    if on_segment(p1, p2, q1):
        return True

    # p1, q1 and q2 are collinear and q2 lies on segment p1q1
    if on_segment(p1, q2, q1):
        return True

    # p2, q2 and p1 are collinear and p1 lies on segment p2q2
    if on_segment(p2, p1, q2):
        return True

    # p2, q2 and q1 are collinear and q1 lies on segment p2q2
    if on_segment(p2, q1, q2):
        return True

    return False  # Doesn't fall in any of the above cases


# ------------------ Test (Same as Java main) ------------------

p1 = (1, 1)
q1 = (10, 1)
p2 = (1, 2)
q2 = (10, 2)
print(intersect(p1, q1, p2, q2))  # False

p1 = (10, 1)
q1 = (0, 10)
p2 = (0, 0)
q2 = (10, 10)
print(intersect(p1, q1, p2, q2))  # True

p1 = (-5, -5)
q1 = (0, 0)
p2 = (1, 1)
q2 = (10, 10)
print(intersect(p1, q1, p2, q2))  # False
