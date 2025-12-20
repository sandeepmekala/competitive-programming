# Geometry / Computational Geometry


# Problem: https://leetcode.com/problems/rectangle-overlap/
# Idea: It can be solved using line segment intersection concept. It this case there are 4 imaginary line segements of x and y coordinates of both the rectangles should overlap.
# Given 2 segments (left1, right1), (left2, right2)
# They overlap if, left1 < right2 && left2 < right1
#              ----------------(3, 3)
#              |                |
#        ----- | -------(2, 2)  |
#        |     -------|-------- r2
#        |   (1, 1)   |
#        ------------- r1
#          (0, 0)
#
#          0------------2
#               1--------------3
#
def is_rectangle_overlap(rec1, rec2):
    return (rec1[0] < rec2[2] and
            rec2[0] < rec1[2] and
            rec1[1] < rec2[3] and
            rec2[1] < rec1[3])


# ------------------ Test (Same as Java main) ------------------

rec1 = [0, 0, 2, 2]   # bottom left, top right
rec2 = [1, 1, 3, 3]

print(is_rectangle_overlap(rec1, rec2))  # Expected: True
