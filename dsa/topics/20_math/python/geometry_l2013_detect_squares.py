# Geometry / Computational Geometry


class DetectSquares:
    def __init__(self):
        # cntPoints[x][y] stores frequency of point (x, y)
        self.cntPoints = [[0] * 1001 for _ in range(1001)]
        self.points = []


    # Problem: https://leetcode.com/problems/detect-squares/
    # Idea: We try all points p3 which together with p1 form the diagonal of non-empty square,
    # it means abs(p1.x-p3.x) == abs(p1.y-p3.y) && abs(p1.x-p3.x) > 0
    # Since we have 2 points p1 and p3, we can form a square by computing the positions of
    # 2 remain points p2, p4.
    # p2 = (p1.x, p3.y)
    # p4 = (p3.x, p1.y)
    def add(self, p):
        self.cntPoints[p[0]][p[1]] += 1
        self.points.append(p)


    def count(self, p1):
        x1, y1 = p1
        count = 0

        for p3 in self.points:
            x3, y3 = p3

            # Skip empty square or invalid square point!
            if abs(x1 - x3) == 0 or abs(x1 - x3) != abs(y1 - y3):
                continue

            count += self.cntPoints[x1][y3] * self.cntPoints[x3][y1]

        return count


# ------------------ Test (Same as Java main) ------------------

obj = DetectSquares()

obj.add([3, 10])
obj.add([11, 2])
obj.add([3, 2])

print(obj.count([11, 10]))  # Expected: 1
