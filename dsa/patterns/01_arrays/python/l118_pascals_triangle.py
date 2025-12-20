"""
L118 - Pascal's Triangle

Problem: https://leetcode.com/problems/pascals-triangle/
Idea: Each row starts and ends with 1. Middle elements are sum of two elements above.
Time: O(n^2)
Space: O(n^2)
"""

def generate(num_rows):
    triangle = []
    
    for i in range(num_rows):
        row = [1] * (i + 1)
        
        for j in range(1, i):
            row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
        
        triangle.append(row)
    
    return triangle


if __name__ == "__main__":
    n = 5
    print(f"Pascal's triangle with {n} rows:")
    result = generate(n)
    for row in result:
        print(row)
