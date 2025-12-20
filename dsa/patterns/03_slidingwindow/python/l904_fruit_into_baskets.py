"""
L904 - Fruit Into Baskets

Problem: https://leetcode.com/problems/fruit-into-baskets/
Idea: Problem can be reframed as find the longest subarray with at most 2 distinct elements
Time: O(n)
Space: O(1) - at most 2 elements in map
"""

def total_fruit(fruits):
    l, r, max_len, n, k = 0, 0, 0, len(fruits), 2
    fruit_map = {}
    
    while r < n:
        fruit_map[fruits[r]] = fruit_map.get(fruits[r], 0) + 1
        
        if len(fruit_map) > k:
            fruit_map[fruits[l]] = fruit_map[fruits[l]] - 1
            if fruit_map[fruits[l]] == 0:
                del fruit_map[fruits[l]]
            l += 1
        
        if len(fruit_map) <= k:
            max_len = max(max_len, r - l + 1)
        
        r += 1
    
    return max_len


if __name__ == "__main__":
    fruits = [1, 2, 3, 2, 2]
    print(f"Input: fruits = {fruits}")
    print(f"Output: {total_fruit(fruits)}")
