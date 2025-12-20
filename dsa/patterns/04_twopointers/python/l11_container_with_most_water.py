"""
L11 - Container With Most Water
Problem: https://leetcode.com/problems/container-with-most-water/
Idea: Move ptrs from both side. Find the max height bar from both sides and its area. Skip smaller bar. Track Max area.
Time: O(n)
Space: O(1)
"""

def max_area(height):
    """
    Find the maximum area of water that can be contained.
    
    Args:
        height: List[int] - Array representing heights of vertical lines
    
    Returns:
        int - Maximum area of water that can be contained
    """
    max_area_val = 0
    l, r = 0, len(height) - 1
    
    while l < r:
        min_height = min(height[l], height[r])
        area = (r - l) * min_height
        max_area_val = max(max_area_val, area)
        
        if height[l] < height[r]:
            l += 1
        else:
            r -= 1
    
    return max_area_val


if __name__ == "__main__":
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    result = max_area(height)
    print(result)  # Expected: 49
