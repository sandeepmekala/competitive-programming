# L904 - Fruit Into Baskets
#
# Problem: https://leetcode.com/problems/fruit-into-baskets/
# Idea: Problem can be reframed as find the longest subarray with at most 2 distinct elements
# Time: O(n)
# Space: O(1) - at most 2 elements in map

def total_fruit(fruits: list[int]) -> int:
    left = 0
    max_len = 0
    basket = {}

    for right, fruit in enumerate(fruits):
        basket[fruit] = basket.get(fruit, 0) + 1

        if len(basket) > 2:
            basket[fruits[left]] -= 1
            if basket[fruits[left]] == 0:
                del basket[fruits[left]]
            left += 1

        # basket always has at most 2 distinct fruits here
        max_len = max(max_len, right - left + 1)

    return max_len


if __name__ == "__main__":
    fruits = [1, 2, 3, 2, 2]
    print(f"Input: fruits = {fruits}")
    print(f"Output: {total_fruit(fruits)}")
