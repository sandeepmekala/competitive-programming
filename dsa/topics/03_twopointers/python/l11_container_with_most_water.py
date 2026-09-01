# L11 - Container With Most Water
#
# Problem: https://leetcode.com/problems/container-with-most-water/
#
# Idea:
# - Use two pointers from both ends
# - Area = width × min(height[left], height[right])
# - Move the pointer with smaller height
#
# Time: O(n)
# Space: O(1)


def max_area(height):
    left, right = 0, len(height) - 1
    max_water = 0

    while left < right:
        width = right - left
        curr_area = width * min(height[left], height[right])
        max_water = max(max_water, curr_area)

        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_water


# -------------------- TEST --------------------
if __name__ == "__main__":
    height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
    print(max_area(height))  # Output: 49
