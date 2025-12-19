"""
L42 - Trapping Rain Water
Problem: https://leetcode.com/problems/trapping-rain-water/
Idea: Track the maximum from left and right
If maxl is minimum, means the water that gets logged will be at max will be height of maxl. Use maxl to find the current position water logging maxl-height[i]
Similarly, update the water logging from the right if maxr is smaller then the maxl.
Time: O(n)
Space: O(1)
"""

def trap(height):
    """
    Calculate the amount of rainwater that can be trapped.
    
    Args:
        height: List[int] - Array representing heights of elevation map
    
    Returns:
        int - Total amount of rainwater that can be trapped
    """
    n = len(height)
    if n <= 2:
        return 0
    
    total = 0
    maxl, maxr = height[0], height[n - 1]
    l, r = 1, n - 2
    
    while l <= r:
        if maxl <= maxr:
            if maxl - height[l] > 0:
                total += maxl - height[l]
            maxl = max(maxl, height[l])
            l += 1
        else:
            if maxr - height[r] > 0:
                total += maxr - height[r]
            maxr = max(maxr, height[r])
            r -= 1
    
    return total


if __name__ == "__main__":
    height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    result = trap(height)
    print(result)  # Expected: 6
