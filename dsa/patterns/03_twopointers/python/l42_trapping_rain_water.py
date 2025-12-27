# L42 - Trapping Rain Water
#
# Problem: https://leetcode.com/problems/trapping-rain-water/
#
# Idea:
# - Use two pointers from both ends
# - Track max height from left (left_max) and right (right_max)
# - Water trapped depends on the smaller of the two maxes
#
# This is different from container with most water problem. Because in this
# we need to focus on addition of all waters trapped in all containers
# based on their respective heights in positions.
# Container problem focuses on finding max water container.
# Time: O(n)
# Space: O(1)


def trap(height):
    if len(height) < 3:
        return 0

    left, right = 0, len(height) - 1
    left_max = right_max = 0
    total_water = 0

    while left < right:
        if height[left] < height[right]:
            left_max = max(left_max, height[left])
            # If heigh is >, it will be update above already. So, no -ve addition.
            total_water += left_max - height[left]
            left += 1
        else:
            right_max = max(right_max, height[right])
            total_water += right_max - height[right]
            right -= 1

    return total_water


# -------------------- TEST --------------------
if __name__ == "__main__":
    height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print(trap(height))  # Output: 6
