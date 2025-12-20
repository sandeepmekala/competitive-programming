import sys

# Problem:
# Idea: Find cumulative sum array from left to right cols. Apply Kadanes algo on that cumulative col sum array. Kadanes algo gives you local max, top and bottom indices.
# these left right indices you can use as left max and right max if kadanes algo return max which is greater than global max.
#
#
#
# Time: O(col*col*row)
# space: O(row)
def maxSum(matrix, m, n):
    maxSumVal = -sys.maxsize
    li = ri = ti = di = -1

    for i in range(n):
        summedCol = [0] * m
        for j in range(i, n):
            currentCol = getColumn(matrix, j)
            summedCol = add(summedCol, currentCol)

            res = kadanesAlgo(summedCol, m)
            if res[0] > maxSumVal:
                maxSumVal = res[0]
                li = i
                ri = j
                ti = res[1]
                di = res[2]

    return [maxSumVal, li, ti, ri, di]


def kadanesAlgo(array, m):
    maxSumVal = -sys.maxsize
    sumVal = 0
    start = end = -1
    tempStart = 0

    for i in range(m):
        sumVal += array[i]

        if sumVal > maxSumVal:
            maxSumVal = sumVal
            start = tempStart
            end = i

        if sumVal < 0:
            sumVal = 0
            tempStart = i + 1

    return [maxSumVal, start, end]


def add(array1, array2):
    temp = [0] * len(array1)
    for i in range(len(array1)):
        temp[i] = array1[i] + array2[i]
    return temp


def getColumn(matrix, j):
    column = [0] * len(matrix)
    for i in range(len(matrix)):
        column[i] = matrix[i][j]
    return column


# ---------------- Test (same as Java main) ----------------

matrix = [
    [2, 1, -3, -4, 5],
    [0, 6, 3, 4, 1],
    [2, -2, -1, 4, -5],
    [-3, 3, 1, 0, 3]
]

result = maxSum(matrix, len(matrix), len(matrix[0]))
print(result)
